package randomcraft.application.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import randomcraft.application.base.enums.Race;
import randomcraft.application.domain.player.dto.PlayerCreateDto;
import randomcraft.application.domain.player.dto.PlayerInfoUpdateDto;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    String createName = "william";
    String createInGameName = "jd";
    String createAfreecaName = "jd101";
    String createYoutubeName = "jd-channel";
    Race createRace = Race.ZERG;

    String updateName = "josh";
    String updateInGameName = "flash";
    String updateAfreecaName = "flash101";
    String updateYoutubeName = "flash-channel";
    Race updateRace = Race.TERRAN;

    @Test
    @DisplayName("Player should be properly created")
    void playerCreate() {
        // given
        PlayerCreateDto createDto = getCreateDto();

        // when
        Player player = Player.createPlayer(createDto);

        // then
        assertThat(player.getName()).isEqualTo(createName);
        assertThat(player.getAfreecaName()).isEqualTo(createAfreecaName);
        assertThat(player.getYoutubeName()).isEqualTo(createYoutubeName);
        assertThat(player.getInGameName()).isEqualTo(createInGameName);
        assertThat(player.getRace()).isEqualTo(createRace);
        assertThat(player.getWinCount()).isEqualTo(0);
        assertThat(player.getLossCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("Player information should be properly updated")
    void playerUpdateInformation() {
        // given
        PlayerCreateDto createDto = getCreateDto();
        Player player = Player.createPlayer(createDto);

        // when
        PlayerInfoUpdateDto updateDto = getUpdateDto();
        player.updatePlayerInfo(updateDto);

        // then
        assertThat(player.getName()).isEqualTo(updateName);
        assertThat(player.getInGameName()).isEqualTo(updateInGameName);
        assertThat(player.getAfreecaName()).isEqualTo(updateAfreecaName);
        assertThat(player.getYoutubeName()).isEqualTo(updateYoutubeName);
        assertThat(player.getRace()).isEqualTo(updateRace);
    }

    PlayerCreateDto getCreateDto() {
        return new PlayerCreateDto(
                createName, createInGameName, createAfreecaName, createYoutubeName, createRace
        );
    }

    PlayerInfoUpdateDto getUpdateDto() {
        return new PlayerInfoUpdateDto(
                updateName, updateInGameName, updateAfreecaName, updateYoutubeName, updateRace
        );
    }
}