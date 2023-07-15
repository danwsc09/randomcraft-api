package randomcraft.application.domain.player;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import randomcraft.application.annotation.ApiPrefixV1Controller;
import randomcraft.application.domain.player.dto.PlayerInfoUpdateDto;
import randomcraft.application.domain.player.dto.PlayerResponseDto;

import java.util.List;

@ApiPrefixV1Controller
@RestController
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/player")
    public List<PlayerResponseDto> getAllPlayers() {
        return playerService.findAllPlayers();
    }

    @PutMapping("/player/{playerId}")
    public PlayerResponseDto updatePlayerInfo(@PathVariable Long playerId, @RequestBody PlayerInfoUpdateDto playerInfoUpdateDto) {
        return playerService.updatePlayerInfo(playerId, playerInfoUpdateDto);
    }
}
