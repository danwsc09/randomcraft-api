package randomcraft.application.domain.match.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public class MatchCreateDto {
    private List<MatchDataCreateDto> matchItems;
    private LocalDate playedOn;
    private String summary;
    private Integer bestOf;
    private Integer gameNumber;
    private String vods;
}
