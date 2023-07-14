package randomcraft.application.domain.match;

import jakarta.persistence.*;
import randomcraft.application.base.BaseEntity;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "matches")
public class Match extends BaseEntity {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "match")
    private List<MatchData> matchDataList;

    @Column(name = "played_on")
    private Timestamp playedOn;

    @Column(name = "summary", columnDefinition = "TEXT")
    private String summary;

    @Column(name = "best_of")
    private Long bestOf;

    @Column(name = "game_number")
    private Long gameNumber;

    @Column(name = "vods", columnDefinition = "TEXT")
    private String vods;

    @Column(name = "is_validated")
    private Boolean isValidated;
}
