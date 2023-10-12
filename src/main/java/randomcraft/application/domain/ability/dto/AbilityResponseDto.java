package randomcraft.application.domain.ability.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import randomcraft.application.domain.ability.Ability;
import randomcraft.application.util.Constants;

import java.time.OffsetDateTime;

@Getter
public class AbilityResponseDto {

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN_FULL_DATE, timezone = Constants.TIME_ZONE)
    private OffsetDateTime createdAt;

    private String name;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN_FULL_DATE, timezone = Constants.TIME_ZONE)
    private OffsetDateTime lastPlayed;

    private Long winCount;
    private Long lossCount;

    public static AbilityResponseDto createFrom(Ability ability) {
        AbilityResponseDto result = new AbilityResponseDto();
        result.id = ability.getId();
        result.createdAt = ability.getCreatedAt();
        result.name = ability.getName();
        result.description = ability.getDescription();
        result.lastPlayed = ability.getLastPlayed();
        result.winCount = ability.getWinCount();
        result.lossCount = ability.getLossCount();

        return result;
    }
}
