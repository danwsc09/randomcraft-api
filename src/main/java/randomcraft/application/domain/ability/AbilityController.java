package randomcraft.application.domain.ability;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import randomcraft.application.annotation.ApiPrefixV1Controller;

@ApiPrefixV1Controller
@RestController
public class AbilityController {

    @GetMapping("/ability")
    public String hello() {
        return "hello world";
    }

}
