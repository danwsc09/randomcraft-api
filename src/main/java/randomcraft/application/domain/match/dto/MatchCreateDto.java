package randomcraft.application.domain.match.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class MatchCreateDto {
    private List<MatchDataCreateDto> matchItems;
    private Timestamp playedOn;
    private String summary;
    private Long bestOf;
    private Long gameNumber;
    private String vods;
}
