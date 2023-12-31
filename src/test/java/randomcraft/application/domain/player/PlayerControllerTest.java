package randomcraft.application.domain.player;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import randomcraft.application.domain.player.dto.PlayerCreateDto;
import randomcraft.application.util.entity.enums.Race;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PlayerControllerTest {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    MockMvc mvc;
    @Autowired
    ObjectMapper mapper;

    String name = "Chris";
    String ign = "Fire";
    String afreecaName = "FireOnAfreeca";
    String youtubeName = "FireOnYoutube";
    Race race = Race.PROTOSS;

    String BASE_URL = "/api/player";

    @Test
    @DisplayName("Player is successfully created and saved to the database")
    @Transactional
    void playerCreateIsSuccessful() throws Exception {
        // given
        PlayerCreateDto createDto = new PlayerCreateDto(name, ign, afreecaName, youtubeName, race);
        String body = mapper.writeValueAsString(createDto);

        // when + then
        mvc.perform(post(BASE_URL)
                        .header("Content-Type", "application/json")
                        .content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());

        List<Player> playerList = playerRepository.findAll();
        assertThat(playerList).hasSize(1);
        assertThat(playerList.get(0).getInGameName()).isEqualTo(ign);
        assertThat(playerList.get(0).getName()).isEqualTo(name);
    }
}
