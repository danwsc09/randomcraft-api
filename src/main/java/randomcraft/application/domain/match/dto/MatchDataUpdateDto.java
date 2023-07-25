package randomcraft.application.domain.match.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import randomcraft.application.util.entity.enums.GameResult;
import randomcraft.application.util.entity.enums.Race;

@Getter @Setter @AllArgsConstructor
public class MatchDataUpdateDto {
    private Integer location;
    private Race race;
    private GameResult result;
    private Long abilityId;
    private Long playerId;
}
