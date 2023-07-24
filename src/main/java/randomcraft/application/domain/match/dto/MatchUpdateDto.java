package randomcraft.application.domain.match.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@AllArgsConstructor
public class MatchUpdateDto {
    private Long id;
    private Timestamp playedOn;
    private String summary;
    private Integer bestOf;
    private Integer gameNumber;
    private String vods;
    private List<MatchDataUpdateDto> matchItems;
}
