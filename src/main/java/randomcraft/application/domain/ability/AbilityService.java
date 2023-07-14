package randomcraft.application.domain.ability;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import randomcraft.application.domain.ability.dto.AbilityDto;
import randomcraft.application.domain.ability.dto.AbilityUpdateDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AbilityService {

    private final AbilityRepository abilityRepository;

    public List<AbilityDto> findAllAbilities() {
        return abilityRepository.findAll().stream()
                .map(AbilityDto::createFrom)
                .toList();
    }

    @Transactional
    public AbilityDto updateAbility(Long id, AbilityUpdateDto updateDto) {

        Ability ability = abilityRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        ability.update(updateDto);

        return AbilityDto.createFrom(ability);
    }
}
