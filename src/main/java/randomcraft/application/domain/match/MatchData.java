package randomcraft.application.domain.match;

import jakarta.persistence.*;
import randomcraft.application.base.BaseDateEntity;
import randomcraft.application.base.enums.GameResult;
import randomcraft.application.base.enums.Race;
import randomcraft.application.domain.ability.Ability;
import randomcraft.application.domain.player.Player;

@Entity
@Table(name = "match_data")
public class MatchData extends BaseDateEntity {

    @Column(name = "location")
    private Long location;

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

}
