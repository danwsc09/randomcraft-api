package randomcraft.application.domain.player;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import randomcraft.application.annotation.ApiPrefixV1Controller;
import randomcraft.application.domain.player.dto.PlayerDto;

import java.util.List;

@ApiPrefixV1Controller
@RestController
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/player")
    public List<PlayerDto> getAllPlayers() {
        return playerService.findAllPlayers();
    }
}
