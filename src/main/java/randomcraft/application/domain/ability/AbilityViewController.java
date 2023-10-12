package randomcraft.application.domain.ability;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AbilityViewController {

    @GetMapping("/ability")
    public String hello(@RequestParam(name = "bool") String bool, Model model) {
        System.out.println("bool = " + bool);
        model.addAttribute("bool", bool);
        return "ability";
    }

}
