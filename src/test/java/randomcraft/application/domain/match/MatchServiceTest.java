package randomcraft.application.domain.match;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import randomcraft.application.domain.ability.Ability;
import randomcraft.application.domain.ability.AbilityRepository;
import randomcraft.application.domain.ability.dto.AbilityCreateDto;
import randomcraft.application.domain.match.dto.MatchDataResponseDto;
import randomcraft.application.domain.match.dto.MatchDataUpdateDto;
import randomcraft.application.domain.match.dto.MatchResponseDto;
import randomcraft.application.domain.match.dto.MatchUpdateDto;
import randomcraft.application.domain.player.Player;
import randomcraft.application.domain.player.PlayerRepository;
import randomcraft.application.domain.player.dto.PlayerCreateDto;
import randomcraft.application.util.Constants;
import randomcraft.application.util.entity.enums.GameResult;
import randomcraft.application.util.entity.enums.Race;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MatchServiceTest {

    @Autowired
    MatchService matchService;
    @Autowired
    MatchRepository matchRepository;
    @Autowired
    MatchDataRepository matchDataRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    AbilityRepository abilityRepository;

    @Test
    @DisplayName("Match is correctly updated when data for 4 players are provided")
    @Transactional
    void correctlyUpdateMatch() throws Exception {
        // given
        Player p1 = helperCreatePlayer();
        Player p2 = helperCreatePlayer();
        Player p3 = helperCreatePlayer();
        Player p4 = helperCreatePlayer();
        playerRepository.saveAll(List.of(p1, p2, p3, p4));

        Ability a1 = helperCreateAbility();
        Ability a2 = helperCreateAbility();
        Ability a3 = helperCreateAbility();
        Ability a4 = helperCreateAbility();
        abilityRepository.saveAll(List.of(a1, a2, a3, a4));

        MatchData md1 = MatchData.create(1, Race.PROTOSS, GameResult.WIN, a1, p1);
        MatchData md2 = MatchData.create(2, Race.PROTOSS, GameResult.WIN, a2, p2);
        MatchData md3 = MatchData.create(3, Race.PROTOSS, GameResult.LOSS, a3, p3);
        MatchData md4 = MatchData.create(4, Race.PROTOSS, GameResult.LOSS, a4, p4);

        Match match = Match.createMatch(
                OffsetDateTime.now(ZoneId.of(Constants.TIME_ZONE)), "summary", 5, 3, "vods",
                List.of(md1, md2, md3, md4)
        );

        Match savedMatch = matchRepository.save(match);

        // when
        String updatedSummary = "update summary";
        String updatedVods = "update vods";
        int updatedBestOf = 7;
        int updatedGameNumber = 1;

        int player1UpdateLocation = 9;
        Race player1UpdateRace = Race.TERRAN;
        Race player2UpdateRace = Race.ZERG;
        GameResult player2UpdateResult = GameResult.LOSS;
        GameResult player3UpdateResult = GameResult.WIN;
        MatchDataUpdateDto mdu1 = new MatchDataUpdateDto(player1UpdateLocation, player1UpdateRace, md1.getResult(), md1.getAbility().getId(), md1.getPlayer().getId());
        MatchDataUpdateDto mdu2 = new MatchDataUpdateDto(md2.getLocation(), player2UpdateRace, player2UpdateResult, md2.getAbility().getId(), md2.getPlayer().getId());
        MatchDataUpdateDto mdu3 = new MatchDataUpdateDto(md3.getLocation(), player1UpdateRace, player3UpdateResult, md3.getAbility().getId(), md3.getPlayer().getId());
        MatchDataUpdateDto mdu4 = new MatchDataUpdateDto(md4.getLocation(), player1UpdateRace, md4.getResult(), md4.getAbility().getId(), md4.getPlayer().getId());

        MatchUpdateDto matchUpdateDto = new MatchUpdateDto(
            savedMatch.getId(), savedMatch.getPlayedOn(), updatedSummary, updatedBestOf, updatedGameNumber, updatedVods,
                List.of(mdu1, mdu2, mdu3, mdu4)
        );

        MatchResponseDto matchResponseDto = matchService.updateMatch(matchUpdateDto);
        List<MatchDataResponseDto> winners = matchResponseDto.getWinners();
        List<MatchDataResponseDto> losers = matchResponseDto.getLosers();

        // then
        assertThat(matchResponseDto.getSummary()).isEqualTo(updatedSummary);
        assertThat(matchResponseDto.getVods()).isEqualTo(updatedVods);
        assertThat(matchResponseDto.getBestOf()).isEqualTo(updatedBestOf);
        assertThat(matchResponseDto.getGameNumber()).isEqualTo(updatedGameNumber);
        assertThat(winners).anyMatch(matchData -> matchData.getPlayerId().equals(p3.getId()));
        assertThat(winners).anyMatch(matchData -> matchData.getRace().equals(player1UpdateRace));
        assertThat(winners).anyMatch(matchData -> matchData.getLocation().equals(player1UpdateLocation));
        assertThat(losers).anyMatch(matchData -> matchData.getPlayerId().equals(p2.getId()));
        assertThat(losers).anyMatch(matchData -> matchData.getRace().equals(player2UpdateRace));

    }

    Player helperCreatePlayer() {
        return Player.createPlayer(new PlayerCreateDto("lee jaedong", "jd", "jd", "jd-yt", Race.ZERG));
    }

    Ability helperCreateAbility() {
        return Ability.create(new AbilityCreateDto("ability 1", "desc 1"));
    }

}
