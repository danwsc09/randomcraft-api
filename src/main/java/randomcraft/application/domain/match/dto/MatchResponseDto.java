package randomcraft.application.domain.match.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import randomcraft.application.util.entity.enums.GameResult;
import randomcraft.application.util.entity.enums.MatchValidationStatus;
import randomcraft.application.domain.match.Match;
import randomcraft.application.util.Constants;

import java.time.OffsetDateTime;
import java.util.List;

@Getter @Setter
public class MatchResponseDto {

    private Long id;
    private OffsetDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN_DATE_ONLY, timezone = Constants.TIME_ZONE)
    private OffsetDateTime playedOn;
    private String summary;
    private Integer bestOf;
    private Integer gameNumber;
    private String vods;
    private MatchValidationStatus validationStatus;
    private List<MatchDataResponseDto> winners;
    private List<MatchDataResponseDto> losers;

    public MatchResponseDto(Match match) {
        id = match.getId();
        createdAt = match.getCreatedAt();
        playedOn = match.getPlayedOn();
        summary = match.getSummary();
        bestOf = match.getBestOf();
        gameNumber = match.getGameNumber();
        vods = match.getVods();
        validationStatus = match.getValidationStatus();

        winners = match.getMatchDataList().stream()
                .filter(matchData -> matchData.getResult().equals(GameResult.WIN))
                .map(matchData -> new MatchDataResponseDto(matchData, matchData.getAbility(), matchData.getPlayer()))
                .toList();

        losers = match.getMatchDataList().stream()
                .filter(matchData -> matchData.getResult().equals(GameResult.LOSS))
                .map(matchData -> new MatchDataResponseDto(matchData, matchData.getAbility(), matchData.getPlayer()))
                .toList();
    }
}
