package randomcraft.application.domain.match;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import randomcraft.application.domain.ability.Ability;
import randomcraft.application.domain.player.Player;
import randomcraft.application.exception.generic.ScInvalidMatchException;
import randomcraft.application.util.Constants;
import randomcraft.application.util.TimeUtil;
import randomcraft.application.util.entity.BaseDateEntity;
import randomcraft.application.util.entity.enums.GameResult;
import randomcraft.application.util.entity.enums.MatchValidationStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "matches")
@Getter
public class Match extends BaseDateEntity {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "match")
    private List<MatchData> matchDataList = new ArrayList<>();

    @Column(name = "played_on")
    private OffsetDateTime playedOn;

    @Column(name = "summary", columnDefinition = "TEXT")
    private String summary;

    @Column(name = "best_of")
    private Integer bestOf;

    @Column(name = "game_number")
    private Integer gameNumber;

    @Column(name = "vods", columnDefinition = "TEXT")
    private String vods;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private MatchValidationStatus validationStatus;

    /**
     * Setting relations
     */

    public void addMatchData(MatchData data) {
        matchDataList.add(data);
        data.setMatch(this);
    }

    /*
        Match Business Logic - Update, Validate/Reject, Create
     */

    public static Match createMatch(
            LocalDate playedOn, String summary, Integer bestOf, Integer gameNumber, String vods,
            List<MatchData> matchDataList
    ) {
        Match match = new Match();
        match.playedOn = OffsetDateTime.of(playedOn, LocalTime.MIDNIGHT, TimeUtil.getZoneOffset(Constants.TIME_ZONE));
        match.summary = summary;
        match.bestOf = bestOf;
        match.gameNumber = gameNumber;
        match.vods = vods;

        for (MatchData data : matchDataList) {
            match.addMatchData(data);
        }

        match.validationStatus = MatchValidationStatus.SUBMITTED;

        match.validateMatchDetail();

        return match;
    }

    public Match updateMatchInfo(
            OffsetDateTime playedOn, String summary, Integer bestOf, Integer gameNumber,
            String vods, List<MatchData> matchDataList
    ) {
        this.playedOn = playedOn;
        this.summary = summary;
        this.bestOf = bestOf;
        this.gameNumber = gameNumber;
        this.vods = vods;

        this.matchDataList = new ArrayList<>();
        for (MatchData matchData : matchDataList) {
            addMatchData(matchData);
        }

        return this;
    }

    public void validateMatchDetail() {
        // 4 players
        if (matchDataList.size() != 4) {
            throw new ScInvalidMatchException("There must be 4 matches");
        }

        // 2 wins and 2 losses
        long winCount = matchDataList.stream()
                .filter(matchData -> matchData.getResult().equals(GameResult.WIN))
                .count();

        long lossCount = matchDataList.stream()
                .filter(matchData -> matchData.getResult().equals(GameResult.LOSS))
                .count();

        if (winCount != 2 || lossCount != 2) {
            throw new ScInvalidMatchException("There must be 2 wins and 2 losses");
        }

        // no overlapping location
        Set<Integer> locationSet = matchDataList.stream()
                .map(MatchData::getLocation)
                .collect(Collectors.toSet());

        if (locationSet.size() != 4) {
            throw new ScInvalidMatchException("There must be 4 unique locations");
        }
    }

    public void approveMatch() {
        validationStatus = MatchValidationStatus.APPROVED;
        List<MatchData> winnersList = matchDataList.stream()
                .filter(matchData -> matchData.getResult().equals(GameResult.WIN))
                .toList();
        List<MatchData> losersList = matchDataList.stream()
                .filter(matchData -> matchData.getResult().equals(GameResult.LOSS))
                .toList();

        winnersList.forEach(matchData -> {
            Player player = matchData.getPlayer();
            player.winGame(playedOn);

            Ability ability = matchData.getAbility();
            ability.winGame(playedOn);
        });

        losersList.forEach(matchData -> {
            Player player = matchData.getPlayer();
            player.loseGame(playedOn);

            Ability ability = matchData.getAbility();
            ability.loseGame(playedOn);
        });
    }

    public void rejectMatch() {
        validationStatus = MatchValidationStatus.REJECTED;
    }

    public void restoreStatusDefault() {
        validationStatus = MatchValidationStatus.SUBMITTED;
    }
}
