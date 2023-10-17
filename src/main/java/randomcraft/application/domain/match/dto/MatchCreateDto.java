package randomcraft.application.domain.match.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MatchCreateDto {
    private List<MatchDataCreateDto> matchItems;
    private LocalDate playedOn;
    private String summary;
    private Integer bestOf;
    private Integer gameNumber;
    private String vods;
}
