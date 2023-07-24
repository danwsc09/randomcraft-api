package randomcraft.application.domain.match.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class MatchInfoUpdateDto {
    private Long id;
    private Timestamp playedOn;
    private String summary;
    private Long bestOf;
    private Long gameNumber;
    private String vods;
}
