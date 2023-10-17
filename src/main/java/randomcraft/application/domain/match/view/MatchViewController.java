package randomcraft.application.domain.match.view;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import randomcraft.application.domain.ability.AbilityService;
import randomcraft.application.domain.ability.dto.AbilityResponseDto;
import randomcraft.application.domain.match.MatchService;
import randomcraft.application.domain.match.dto.MatchCreateDto;
import randomcraft.application.domain.match.dto.MatchDataCreateDto;
import randomcraft.application.domain.match.dto.MatchResponseDto;
import randomcraft.application.domain.player.PlayerService;
import randomcraft.application.domain.player.dto.PlayerResponseDto;
import randomcraft.application.util.entity.enums.GameResult;
import randomcraft.application.util.entity.enums.Location;
import randomcraft.application.util.entity.enums.Race;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class MatchViewController {

    private final MatchService matchService;
    private final PlayerService playerService;
    private final AbilityService abilityService;

    @GetMapping("/match")
    public String matchHomePage(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "20") int size
    ) {

        List<MatchResponseDto> matches = matchService.getAllMatches(page, size).getContent()
                .stream().map(MatchResponseDto::new)
                .collect(Collectors.toList());

        model.addAttribute("matches", matches);

        return "pages/match/home";
    }

    @GetMapping("/match/new")
    public String matchNewPage(Model model) {

        List<PlayerResponseDto> players = playerService.findAllPlayers(PageRequest.of(0, 9999), "", "")
                .getItems();
        List<AbilityResponseDto> abilities = abilityService.findAllAbilities(PageRequest.of(0, 9999), "", "")
                .getItems();

        MatchCreateDto matchCreateDto = new MatchCreateDto();
        matchCreateDto.setMatchItems(List.of(
                new MatchDataCreateDto(), new MatchDataCreateDto(), new MatchDataCreateDto(),
                new MatchDataCreateDto()));

        model.addAttribute("match", matchCreateDto);
        model.addAttribute("players", players);
        model.addAttribute("abilities", abilities);
        model.addAttribute("races", Race.raceList);
        model.addAttribute("locations", Location.fightingSpiritLocations);
        model.addAttribute("results", GameResult.gameResultList);

        return "pages/match/new";
    }

    @PostMapping("/match/new")
    public String createMatch(MatchCreateDto matchCreateDto) {

        System.out.println("matchCreateDto = " + matchCreateDto.getPlayedOn());
        System.out.println(matchCreateDto.getMatchItems().get(0));
        System.out.println(matchCreateDto.getMatchItems().get(1));
        System.out.println(matchCreateDto.getMatchItems().get(2));
        System.out.println(matchCreateDto.getMatchItems().get(3));
        matchService.createMatch(matchCreateDto);

        return "redirect:/match";
    }
}
