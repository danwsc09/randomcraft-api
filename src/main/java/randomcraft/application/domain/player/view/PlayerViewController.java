package randomcraft.application.domain.player.view;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import randomcraft.application.domain.player.Player;
import randomcraft.application.domain.player.PlayerService;
import randomcraft.application.domain.player.dto.PlayerCreateDto;
import randomcraft.application.domain.player.dto.PlayerInfoUpdateDto;
import randomcraft.application.domain.player.dto.PlayerResponseDto;
import randomcraft.application.util.entity.enums.Race;
import randomcraft.application.util.response.PaginationResponse;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayerViewController {

    private final PlayerService playerService;

    @GetMapping("/player")
    public String playerHomePage(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "20") int size
    ) {
        PaginationResponse<Player, PlayerResponseDto> players = playerService.findAllPlayers(
                PageRequest.of(page, size), "", "");

        model.addAttribute("players", players.getItems());

        return "pages/player/home";
    }

    @GetMapping("/player/new")
    public String newPlayerPage(Model model, PlayerCreateDto playerCreateDto) {
        List<Race> raceList = List.of(Race.ZERG, Race.PROTOSS, Race.TERRAN);

        model.addAttribute("player", playerCreateDto);
        model.addAttribute("races", raceList);

        return "pages/player/new";
    }

    @PostMapping("/player/new")
    public String createNewPlayer(PlayerCreateDto playerCreateDto) {
        System.out.println("playerCreateDto = " + playerCreateDto);
        playerService.createPlayer(playerCreateDto);

        return "redirect:/player";
    }

    @GetMapping("/player/edit/{playerId}")
    public String newPlayerPage(@PathVariable("playerId") long playerId, Model model) {
        PlayerResponseDto player = playerService.findPlayerById(playerId);
        List<Race> raceList = List.of(Race.ZERG, Race.PROTOSS, Race.TERRAN);

        model.addAttribute("player", player);
        model.addAttribute("races", raceList);

        return "pages/player/edit";
    }

    @PostMapping("/player/edit/{playerId}")
    public String editPlayerInfo(@PathVariable("playerId") long playerId, PlayerInfoUpdateDto playerInfoUpdateDto) {
        playerService.updatePlayerInfo(playerId, playerInfoUpdateDto);

        return "redirect:/player";
    }

    @GetMapping("/player/delete/{playerId}")
    public String deletePlayer(@PathVariable("playerId") long playerId) {
        playerService.deletePlayerById(playerId);

        return "redirect:/player";
    }
}
