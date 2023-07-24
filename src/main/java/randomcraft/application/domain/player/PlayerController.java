package randomcraft.application.domain.player;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import randomcraft.application.domain.player.dto.PlayerInfoUpdateDto;
import randomcraft.application.domain.player.dto.PlayerResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/")
    public List<PlayerResponseDto> getAllPlayers() {
        return playerService.findAllPlayers();
    }

    @PutMapping("/{playerId}")
    public PlayerResponseDto updatePlayerInfo(@PathVariable Long playerId, @RequestBody PlayerInfoUpdateDto playerInfoUpdateDto) {
        return playerService.updatePlayerInfo(playerId, playerInfoUpdateDto);
    }
}
