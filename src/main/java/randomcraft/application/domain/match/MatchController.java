package randomcraft.application.domain.match;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import randomcraft.application.domain.match.dto.MatchResponseDto;
import randomcraft.application.domain.match.dto.MatchStatusUpdateDto;
import randomcraft.application.domain.match.dto.MatchUpdateDto;
import randomcraft.application.util.Constants;
import randomcraft.application.util.response.PaginationResponse;

@RestController
@RequestMapping("/api/match")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;


    @PutMapping("/")
    public ResponseEntity<MatchResponseDto> updateMatch(MatchUpdateDto updateDto) {

        return ResponseEntity.ok(matchService.updateMatch(updateDto));
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<MatchResponseDto> getMatchById(@PathVariable Long matchId) {
        return ResponseEntity.ok(matchService.getMatchById(matchId));
    }

    @GetMapping("/")
    public ResponseEntity<PaginationResponse<Match, MatchResponseDto>> getAllMatches(
            @RequestParam(defaultValue = Constants.PAGINATION_DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.PAGINATION_DEFAULT_SIZE) int size
    ) {
        return ResponseEntity.ok(matchService.getAllMatches(page, size));
    }

    @PatchMapping("/verify")
    public ResponseEntity<MatchResponseDto> updateMatchStatus(@RequestBody MatchStatusUpdateDto statusUpdateDto) {

        return ResponseEntity.ok(matchService.updateMatchStatus(statusUpdateDto));
    }
}
