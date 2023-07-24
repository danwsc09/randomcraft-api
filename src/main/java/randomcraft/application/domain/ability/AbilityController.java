package randomcraft.application.domain.ability;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import randomcraft.application.domain.ability.dto.AbilityDto;
import randomcraft.application.domain.ability.dto.AbilityUpdateDto;

import java.util.List;

@RestController
@RequestMapping("/api/ability")
@RequiredArgsConstructor
public class AbilityController {

    private final AbilityService abilityService;

    @GetMapping("/")
    public List<AbilityDto> getAbilities() {
        return abilityService.findAllAbilities();
    }

    @PutMapping("/{id}")
    public AbilityDto updateAbility(@PathVariable Long id, @RequestBody AbilityUpdateDto updateDto) {
        return abilityService.updateAbility(id, updateDto);
    }

}
