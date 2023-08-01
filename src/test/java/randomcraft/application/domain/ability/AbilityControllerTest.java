package randomcraft.application.domain.ability;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import randomcraft.application.domain.ability.dto.AbilityCreateDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AbilityControllerTest {
    @Autowired
    AbilityRepository abilityRepository;
    @Autowired
    MockMvc mvc;
    @Autowired
    ObjectMapper mapper;

    String BASE_URL = "/api/ability";

    String name = "abilityName";
    String description = "abilityDescription";

    @Test
    @DisplayName("Ability is successfully created and saved to the database")
    void abilityCreationIsSuccessful() throws Exception {
        // given
        AbilityCreateDto createDto = new AbilityCreateDto(name, description);
        String body = mapper.writeValueAsString(createDto);

        // when + then
        mvc.perform(post(BASE_URL)
                        .header("Content-Type", "application/json")
                        .content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.description").exists());

        List<Ability> abilityL = abilityRepository.findAll();
        assertThat(abilityL).hasSize(1);
        assertThat(abilityL.get(0).getDescription()).isEqualTo(description);
        assertThat(abilityL.get(0).getName()).isEqualTo(name);
    }
}