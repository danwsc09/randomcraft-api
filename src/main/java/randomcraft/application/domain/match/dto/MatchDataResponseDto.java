package randomcraft.application.domain.match.dto;

import lombok.Getter;
import lombok.Setter;
import randomcraft.application.util.entity.enums.Race;
import randomcraft.application.domain.ability.Ability;
import randomcraft.application.domain.match.MatchData;
import randomcraft.application.domain.player.Player;

@Getter @Setter
public class MatchDataResponseDto {
    private Long matchDataId;
    private Integer location;
    private Race race;
    private Long abilityId;
    private String abilityName;
    private Long playerId;
    private String playerName;
    private String playerInGameName;

    public MatchDataResponseDto(MatchData matchData, Ability ability, Player player) {
        matchDataId = matchData.getId();
        location = matchData.getLocation();
        race = matchData.getRace();
        abilityId = ability.getId();
        abilityName = ability.getName();
        playerId = player.getId();
        playerName = player.getName();
        playerInGameName = player.getInGameName();
    }
}
