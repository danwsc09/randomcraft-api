package randomcraft.application.domain.ability.view;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import randomcraft.application.domain.ability.Ability;
import randomcraft.application.domain.ability.AbilityService;
import randomcraft.application.domain.ability.dto.AbilityCreateDto;
import randomcraft.application.domain.ability.dto.AbilityResponseDto;
import randomcraft.application.util.response.PaginationResponse;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AbilityViewController {

    private final AbilityService abilityService;

    @GetMapping("/ability")
    public String abilityHomePage(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "20") int size
    ) {

        PaginationResponse<Ability, AbilityResponseDto> paginatedAbilities = abilityService.findAllAbilities(
                PageRequest.of(page, size), "", "");
        List<AbilityResponseDto> abilities = paginatedAbilities.getItems();
        model.addAttribute("abilities", abilities);

        return "pages/ability/home";
    }

    @GetMapping("/ability/new")
    public String abilityCreatePage(Model model, AbilityCreateDto abilityCreateDto) {
        model.addAttribute("ability", abilityCreateDto);
        return "pages/ability/new";
    }

    @PostMapping("/ability/new")
    public String abilityCreate(AbilityCreateDto abilityCreateDto) {

        System.out.println("abilityCreateDto = " + abilityCreateDto);
        abilityService.createAbility(abilityCreateDto);

        return "redirect:/ability";
    }

}
