package randomcraft.application.domain.ability;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Getter;
import randomcraft.application.base.BaseEntity;
import randomcraft.application.util.Constants;

import java.sql.Timestamp;

@Entity
@Table(name = "abilities")
@Getter
public class Ability extends BaseEntity {
    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "last_played")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN, timezone = Constants.TIME_ZONE)
    private Timestamp lastPlayed;

    @Column(name = "win_count")
    private Long winCount;

    @Column(name = "loss_count")
    private Long lossCount;
}
