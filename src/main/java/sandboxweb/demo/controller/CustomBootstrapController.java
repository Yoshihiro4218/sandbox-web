package sandboxweb.demo.controller;

import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bootstrap/custom/form")
@Slf4j
public class CustomBootstrapController {

    @GetMapping("")
    public String index(Model model) {
        return "bootstrap/customForm";
    }
}
