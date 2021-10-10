package HandMaven.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandMavenController {

    @GetMapping("/")
    public String welcomeMessage() {
        return "I made this with my own two hands. ^,";
    }
}
