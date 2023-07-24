package randomcraft.application.domain.ability.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import randomcraft.application.domain.ability.Ability;
import randomcraft.application.util.Constants;

import java.sql.Timestamp;

@Getter
public class AbilityDto {

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN_FULL_DATE, timezone = Constants.TIME_ZONE)
    private Timestamp createdAt;

    private String name;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN_FULL_DATE, timezone = Constants.TIME_ZONE)
    private Timestamp lastPlayed;

    private Long winCount;
    private Long lossCount;

    public static AbilityDto createFrom(Ability ability) {
        AbilityDto result = new AbilityDto();
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
