package randomcraft.application.domain.ability;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import randomcraft.application.domain.ability.dto.AbilityCreateDto;
import randomcraft.application.domain.ability.dto.AbilityUpdateDto;

import static org.assertj.core.api.Assertions.assertThat;

class AbilityTest {

    private final String abilityName = "ability name";
    private final String abilityDescription = "ability description";

    @Test
    @DisplayName("Ability information should be properly updated")
    void abilityUpdateInformation() {
        // given
        AbilityCreateDto abilityCreateDto = new AbilityCreateDto(abilityName, abilityDescription);
        Ability ability = Ability.create(abilityCreateDto);
        String updatedName = "updated ability name";
        String updatedDescription = "updated ability description";
        AbilityUpdateDto updateDto = new AbilityUpdateDto(updatedName, updatedDescription);

        // when
        ability = ability.updateInformation(updateDto);

        // then
        assertThat(ability.getName()).isEqualTo(updatedName);
        assertThat(ability.getDescription()).isEqualTo(updatedDescription);
    }

    @Test
    @DisplayName("Ability win count is updated properly")
    void abilityUpdateWinCount() {
        // given
        AbilityCreateDto abilityCreateDto = new AbilityCreateDto(abilityName, abilityDescription);
        Ability ability = Ability.create(abilityCreateDto);

        // when
        ability.increaseLossCount();

        // then
        assertThat(ability.getLossCount()).isEqualTo(1);
        assertThat(ability.getWinCount()).isZero();
    }

    @Test
    @DisplayName("Ability loss count is updated properly")
    void abilityUpdateLossCount() {
        // given
        AbilityCreateDto abilityCreateDto = new AbilityCreateDto(abilityName, abilityDescription);
        Ability ability = Ability.create(abilityCreateDto);

        // when
        ability.increaseWinCount();

        // then
        assertThat(ability.getWinCount()).isEqualTo(1);
        assertThat(ability.getLossCount()).isZero();
    }

    @Test
    @DisplayName("Ability should be properly initialized when created")
    void abilityCreate() {
        // given
        AbilityCreateDto abilityCreateDto = new AbilityCreateDto(abilityName, abilityDescription);

        // when
        Ability ability = Ability.create(abilityCreateDto);

        // then
        assertThat(ability.getDescription()).isEqualTo(abilityDescription);
        assertThat(ability.getName()).isEqualTo(abilityName);
        assertThat(ability.getWinCount()).isZero();
        assertThat(ability.getLossCount()).isZero();
    }
}