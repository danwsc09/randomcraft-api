package randomcraft.application.domain.player;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import randomcraft.application.base.BaseEntity;
import randomcraft.application.base.enums.Race;
import randomcraft.application.util.Constants;

import java.sql.Timestamp;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "in_game_name")
    private String inGameName;

    @Column(name = "afreeca_name")
    private String afreecaName;

    @Column(name = "youtube_name")
    private String youtubeName;

    @Column(name = "race")
    @Enumerated(EnumType.STRING)
    private Race race;

    @Column(name = "last_played")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN, timezone = Constants.TIME_ZONE)
    private Timestamp lastPlayed;
}
