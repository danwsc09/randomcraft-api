package randomcraft.application.domain.match;

import jakarta.persistence.*;
import lombok.Getter;
import randomcraft.application.base.BaseDateEntity;
import randomcraft.application.base.enums.GameResult;
import randomcraft.application.base.enums.Race;
import randomcraft.application.domain.ability.Ability;
import randomcraft.application.domain.player.Player;

@Entity
@Table(name = "match_data")
@Getter
public class MatchData extends BaseDateEntity {

    @Column(name = "location")
    private Integer location;

    @Column(name = "race")
    @Enumerated(EnumType.STRING)
    private Race race;

    @Column(name = "result")
    @Enumerated(EnumType.STRING)
    private GameResult result;

    @ManyToOne
    @JoinColumn(name = "ability_id", nullable = false, referencedColumnName = "id")
    private Ability ability;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false, referencedColumnName = "id")
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id")
    private Match match;

    /**
     * Setting relations
     */

    public void setMatch(Match match) {
        this.match = match;
    }

    /**
     * Business Logic for MatchData - create, update, delete
     */

    public static MatchData create(Integer location, Race race, GameResult result, Ability ability, Player player) {
        MatchData matchData = new MatchData();

        matchData.location = location;
        matchData.race = race;
        matchData.result = result;
        matchData.ability = ability;
        matchData.player = player;

        return matchData;
    }

    public MatchData updateMatchData(
            Integer location, Race race, GameResult result, Ability ability, Player player
    ) {
        this.location = location;
        this.race = race;
        this.result = result;
        this.ability = ability;
        this.player = player;
        return this;
    }

}
