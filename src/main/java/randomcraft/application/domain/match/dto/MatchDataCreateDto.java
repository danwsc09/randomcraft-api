package randomcraft.application.domain.match.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import randomcraft.application.util.entity.enums.GameResult;
import randomcraft.application.util.entity.enums.Race;

@Getter
@Setter
@ToString
public class MatchDataCreateDto {
    private Integer location;
    private Race race;
    private GameResult result;
    private Long abilityId;
    private Long playerId;
}
