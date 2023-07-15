package randomcraft.application.domain.ability.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AbilityCreateDto {
    private String name;
    private String description;
}
