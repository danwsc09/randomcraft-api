package randomcraft.application.domain.player;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import randomcraft.application.domain.player.dto.PlayerCreateDto;
import randomcraft.application.domain.player.dto.PlayerInfoUpdateDto;
import randomcraft.application.util.Constants;
import randomcraft.application.util.entity.BaseDateEntity;
import randomcraft.application.util.entity.enums.Race;

import java.sql.Timestamp;

@Entity
@Table(name = "players")
@Getter
@ToString
public class Player extends BaseDateEntity {

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

    @Column(name = "win_count")
    private Long winCount;

    @Column(name = "loss_count")
    private Long lossCount;

    @Column(name = "last_played")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN_FULL_DATE, timezone = Constants.TIME_ZONE)
    private Timestamp lastPlayed;

    /*
        Business Logic
     */
    public static Player createPlayer(PlayerCreateDto dto) {
        Player player = new Player();

        player.name = dto.getName();
        player.inGameName = dto.getInGameName();
        player.youtubeName = dto.getYoutubeName();
        player.afreecaName = dto.getAfreecaName();
        player.race = dto.getRace();

        player.winCount = 0L;
        player.lossCount = 0L;

        return player;
    }

    public Player updatePlayerInfo(PlayerInfoUpdateDto dto) {

        this.race = dto.getRace();
        this.name = dto.getName();
        this.inGameName = dto.getInGameName();
        this.afreecaName = dto.getAfreecaName();
        this.youtubeName = dto.getYoutubeName();

        return this;
    }

    public Player winGame(Timestamp playedOn) {
        this.winCount++;

        if (this.lastPlayed == null || this.lastPlayed.before(playedOn)) {
            this.lastPlayed = playedOn;
        }

        return this;
    }

    public Player loseGame(Timestamp playedOn) {
        this.lossCount++;

        if (this.lastPlayed == null || this.lastPlayed.before(playedOn)) {
            this.lastPlayed = playedOn;
        }

        return this;
    }
}
