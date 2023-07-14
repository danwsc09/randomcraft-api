package randomcraft.application.domain.ability;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import randomcraft.application.annotation.ApiPrefixV1Controller;
import randomcraft.application.domain.ability.dto.AbilityDto;
import randomcraft.application.domain.ability.dto.AbilityUpdateDto;

import java.util.List;

@ApiPrefixV1Controller
@RestController
@RequiredArgsConstructor
public class AbilityController {

    private final AbilityService abilityService;

    @GetMapping("/ability")
    public List<AbilityDto> getAbilities() {
        return abilityService.findAllAbilities();
    }

    @PutMapping("/ability/{id}")
    public AbilityDto updateAbility(@PathVariable Long id, @RequestBody AbilityUpdateDto updateDto) {
        return abilityService.updateAbility(id, updateDto);
    }

}
