package randomcraft.application.domain.player;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import randomcraft.application.domain.player.dto.PlayerCreateDto;
import randomcraft.application.domain.player.dto.PlayerInfoUpdateDto;
import randomcraft.application.domain.player.dto.PlayerResponseDto;
import randomcraft.application.util.Constants;
import randomcraft.application.util.response.PaginationResponse;

import java.util.List;

@RestController
@RequestMapping("/api/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping()
    public ResponseEntity<PaginationResponse<Player, PlayerResponseDto>> getAllPlayers(
            @RequestParam(name = "page", defaultValue = Constants.PAGINATION_DEFAULT_PAGE) int page,
            @RequestParam(name = "size", defaultValue = Constants.PAGINATION_DEFAULT_SIZE) int size,
            @RequestParam(name = "name", defaultValue = "") String name,
            @RequestParam(name = "ign", defaultValue = "") String ign
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(playerService.findAllPlayers(pageRequest, name, ign));
    }

    @PutMapping("/{playerId}")
    public ResponseEntity<PlayerResponseDto> updatePlayerInfo(@PathVariable Long playerId, @RequestBody PlayerInfoUpdateDto playerInfoUpdateDto) {
        return ResponseEntity.ok(playerService.updatePlayerInfo(playerId, playerInfoUpdateDto));
    }

    @PostMapping()
    public ResponseEntity<PlayerResponseDto> createPlayer(@RequestBody PlayerCreateDto playerCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.createPlayer(playerCreateDto));
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<PlayerResponseDto> deletePlayer(@PathVariable Long playerId) {
        return ResponseEntity.ok(playerService.deletePlayerById(playerId));
    }

}
