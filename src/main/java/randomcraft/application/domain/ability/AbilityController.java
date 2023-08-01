package randomcraft.application.domain.ability;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import randomcraft.application.domain.ability.dto.AbilityCreateDto;
import randomcraft.application.domain.ability.dto.AbilityResponseDto;
import randomcraft.application.domain.ability.dto.AbilityUpdateDto;

import java.util.List;

@RestController
@RequestMapping("/api/ability")
@RequiredArgsConstructor
public class AbilityController {

    private final AbilityService abilityService;

    @GetMapping()
    public List<AbilityResponseDto> getAbilities() {
        return abilityService.findAllAbilities();
    }

    @PutMapping("/{abilityId}")
    public ResponseEntity<AbilityResponseDto> updateAbility(@PathVariable(name = "abilityId") Long abilityId, @RequestBody AbilityUpdateDto updateDto) {
        return ResponseEntity.ok(abilityService.updateAbility(abilityId, updateDto));
    }

    @PostMapping()
    public ResponseEntity<AbilityResponseDto> createAbility(AbilityCreateDto abilityCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(abilityService.createAbility(abilityCreateDto));
    }

    @DeleteMapping("/{abilityId}")
    public ResponseEntity<AbilityResponseDto> deleteAbility(@PathVariable(name = "abilityId") Long abilityId) {
        return ResponseEntity.ok(abilityService.deleteAbility(abilityId));
    }
}
