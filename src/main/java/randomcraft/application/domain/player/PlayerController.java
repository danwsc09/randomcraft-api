package randomcraft.application.domain.player;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import randomcraft.application.domain.player.dto.PlayerCreateDto;
import randomcraft.application.domain.player.dto.PlayerInfoUpdateDto;
import randomcraft.application.domain.player.dto.PlayerResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping()
    public ResponseEntity<List<PlayerResponseDto>> getAllPlayers() {
        return ResponseEntity.ok(playerService.findAllPlayers());
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
