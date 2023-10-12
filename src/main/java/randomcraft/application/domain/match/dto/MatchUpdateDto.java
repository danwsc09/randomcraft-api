package randomcraft.application.domain.match.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class MatchUpdateDto {
    private Long id;
    private OffsetDateTime playedOn;
    private String summary;
    private Integer bestOf;
    private Integer gameNumber;
    private String vods;
    private List<MatchDataUpdateDto> matchItems;
}
