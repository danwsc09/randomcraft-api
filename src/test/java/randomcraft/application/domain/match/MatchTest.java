package randomcraft.application.domain.match;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import randomcraft.application.domain.ability.Ability;
import randomcraft.application.domain.ability.dto.AbilityCreateDto;
import randomcraft.application.domain.player.Player;
import randomcraft.application.domain.player.dto.PlayerCreateDto;
import randomcraft.application.exception.generic.ScInvalidMatchException;
import randomcraft.application.util.entity.enums.GameResult;
import randomcraft.application.util.entity.enums.MatchValidationStatus;
import randomcraft.application.util.entity.enums.Race;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {

    @Test
    @DisplayName("Updating match with valid information is successful")
    void updateMatchInformationIsSuccessful() throws Exception {
        // given
        Match match = helperCreateMatch();
        String updatedSummary = "new summary";
        Integer updatedBestOf = 51;
        Integer updatedGameNumber = 50;
        String updatedVods = "new vods";

        // when
        match.updateMatchInfo(match.getPlayedOn(), updatedSummary, updatedBestOf, updatedGameNumber, updatedVods, List.of());

        // then
        assertThat(match.getSummary()).isEqualTo(updatedSummary);
        assertThat(match.getBestOf()).isEqualTo(updatedBestOf);
    }


    @Test
    @DisplayName("Updating a 2v2 match with data for 3 players fails")
    void updateMatchWithThreeMatchItems() throws Exception {
        // given
        MatchData data1 = MatchData.create(
                12, Race.PROTOSS, GameResult.WIN, helperCreateAbility(), helperCreatePlayer()
        );
        MatchData data2 = MatchData.create(
                12, Race.PROTOSS, GameResult.WIN, helperCreateAbility(), helperCreatePlayer()
        );
        MatchData data3 = MatchData.create(
                12, Race.PROTOSS, GameResult.LOSS, helperCreateAbility(), helperCreatePlayer()
        );

        // when + then
        Assertions.assertThrows(ScInvalidMatchException.class, () -> {
            Match.createMatch(
                    LocalDate.now(),
                    "", 1, 1, "",
                    List.of(data1, data2, data3)
            );
        });

    }

    @Test
    @DisplayName("Approving a match changes match status to approved")
    void approveMatchChangesStatus() throws Exception {
        // given
        Match match = helperCreateMatch();

        // when
        match.approveMatch();

        // then
        assertThat(match.getValidationStatus()).isEqualByComparingTo(MatchValidationStatus.APPROVED);
    }

    Match helperCreateMatch() {

        MatchData data1 = MatchData.create(12, Race.PROTOSS, GameResult.WIN,
                helperCreateAbility(),
                helperCreatePlayer());

        MatchData data2 = MatchData.create(1, Race.PROTOSS, GameResult.WIN,
                helperCreateAbility(),
                helperCreatePlayer());

        MatchData data3 = MatchData.create(2, Race.PROTOSS, GameResult.LOSS,
                helperCreateAbility(),
                helperCreatePlayer());

        MatchData data4 = MatchData.create(3, Race.PROTOSS, GameResult.LOSS,
                helperCreateAbility(),
                helperCreatePlayer());


        return Match.createMatch(
                LocalDate.now(), "summary", 5, 1, "",
                List.of(data1, data2, data3, data4)
        );
    }

    Player helperCreatePlayer() {
        return Player.createPlayer(new PlayerCreateDto("lee jaedong", "jd", "jd", "jd-yt", Race.ZERG));
    }

    Ability helperCreateAbility() {
        return Ability.create(new AbilityCreateDto("ability 1", "desc 1"));
    }


}
