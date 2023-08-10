package randomcraft.application.domain.ability;

import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import randomcraft.application.domain.ability.dto.AbilityCreateDto;
import randomcraft.application.domain.ability.dto.AbilityResponseDto;
import randomcraft.application.domain.ability.dto.AbilityUpdateDto;
import randomcraft.application.util.response.PaginationResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AbilityService {

    private final AbilityRepository abilityRepository;

    public PaginationResponse<Ability, AbilityResponseDto> findAllAbilities(PageRequest pageRequest, String name, String description) {

        Page<Ability> abilities = abilityRepository.findAllByNameContainingIgnoreCaseAndDescriptionContainingIgnoreCase(
                name, description, pageRequest
        );

        List<AbilityResponseDto> list = abilities.stream()
                .map(AbilityResponseDto::createFrom)
                .toList();

        return new PaginationResponse(abilities, list);
    }

    @Transactional
    public AbilityResponseDto updateAbility(Long id, AbilityUpdateDto updateDto) {

        Ability ability = abilityRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        ability.updateInformation(updateDto);

        return AbilityResponseDto.createFrom(ability);
    }

    @Transactional
    public AbilityResponseDto createAbility(AbilityCreateDto createDto) {

        Ability ability = Ability.create(createDto);
        abilityRepository.save(ability);

        return AbilityResponseDto.createFrom(ability);
    }

    public AbilityResponseDto deleteAbility(Long abilityId) {
        Ability ability = abilityRepository.findById(abilityId)
                .orElse(null);

        if (ability == null) return null;

        abilityRepository.deleteById(abilityId);
        return AbilityResponseDto.createFrom(ability);
    }
}
