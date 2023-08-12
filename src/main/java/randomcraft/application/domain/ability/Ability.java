package randomcraft.application.domain.ability;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import randomcraft.application.util.entity.BaseDateEntity;
import randomcraft.application.domain.ability.dto.AbilityCreateDto;
import randomcraft.application.domain.ability.dto.AbilityUpdateDto;
import randomcraft.application.util.Constants;

import java.sql.Timestamp;

@Entity
@Table(name = "abilities")
@Getter
public class Ability extends BaseDateEntity {
    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "last_played")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN_FULL_DATE, timezone = Constants.TIME_ZONE)
    private Timestamp lastPlayed;

    @Column(name = "win_count")
    private Long winCount;

    @Column(name = "loss_count")
    private Long lossCount;

    /*
        Business Logic
     */
    public static Ability create(AbilityCreateDto dto) {
        Ability ability = new Ability();

        ability.description = dto.getDescription();
        ability.name = dto.getName();
        ability.winCount = 0L;
        ability.lossCount = 0L;

        return ability;
    }

    public Ability updateInformation(AbilityUpdateDto dto) {
        this.name = dto.getName();
        this.description = dto.getDescription();
        return this;
    }

    public Ability winGame(Timestamp playedOn) {
        this.winCount += 1;

        if (this.lastPlayed == null || this.lastPlayed.before(playedOn)) {
            this.lastPlayed = playedOn;
        }

        return this;
    }

    public Ability loseGame(Timestamp playedOn) {
        this.lossCount += 1;

        if (this.lastPlayed == null || this.lastPlayed.before(playedOn)) {
            this.lastPlayed = playedOn;
        }

        return this;
    }
}
