package randomcraft.application.domain.ability.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public class AbilityCreateDto {
    private String name;
    private String description;
}
