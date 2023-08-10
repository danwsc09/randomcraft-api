package randomcraft.application.domain.ability;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import randomcraft.application.domain.ability.dto.AbilityCreateDto;
import randomcraft.application.domain.ability.dto.AbilityResponseDto;
import randomcraft.application.domain.ability.dto.AbilityUpdateDto;
import randomcraft.application.util.Constants;
import randomcraft.application.util.response.PaginationResponse;

import java.util.List;

@RestController
@RequestMapping("/api/ability")
@RequiredArgsConstructor
public class AbilityController {

    private final AbilityService abilityService;

    @GetMapping()
    public ResponseEntity<PaginationResponse<Ability, AbilityResponseDto>> getAbilities(
            @RequestParam(name = "page", defaultValue = Constants.PAGINATION_DEFAULT_PAGE) int page,
            @RequestParam(name = "size", defaultValue = Constants.PAGINATION_DEFAULT_SIZE) int size,
            @RequestParam(name = "name", defaultValue = "") String name,
            @RequestParam(name = "description", defaultValue = "") String description
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return ResponseEntity.ok(abilityService.findAllAbilities(pageRequest, name, description));
    }

    @PutMapping("/{abilityId}")
    public ResponseEntity<AbilityResponseDto> updateAbility(@PathVariable(name = "abilityId") Long abilityId, @RequestBody AbilityUpdateDto updateDto) {
        return ResponseEntity.ok(abilityService.updateAbility(abilityId, updateDto));
    }

    @PostMapping()
    public ResponseEntity<AbilityResponseDto> createAbility(@RequestBody AbilityCreateDto abilityCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(abilityService.createAbility(abilityCreateDto));
    }

    @DeleteMapping("/{abilityId}")
    public ResponseEntity<AbilityResponseDto> deleteAbility(@PathVariable(name = "abilityId") Long abilityId) {
        return ResponseEntity.ok(abilityService.deleteAbility(abilityId));
    }
}
