package randomcraft.application.domain.match.dto;

import lombok.Getter;
import lombok.Setter;
import randomcraft.application.util.entity.enums.GameResult;
import randomcraft.application.util.entity.enums.Race;

@Getter
@Setter
public class MatchDataCreateDto {
    private Long location;
    private Race race;
    private GameResult result;
    private Long abilityId;
    private Long playerId;
}
