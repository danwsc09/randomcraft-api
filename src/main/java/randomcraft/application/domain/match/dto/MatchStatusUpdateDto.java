package randomcraft.application.domain.match.dto;

import lombok.Getter;
import lombok.Setter;
import randomcraft.application.util.entity.enums.MatchValidationStatus;

@Getter @Setter
public class MatchStatusUpdateDto {
    private Long matchId;
    private MatchValidationStatus status;
}
