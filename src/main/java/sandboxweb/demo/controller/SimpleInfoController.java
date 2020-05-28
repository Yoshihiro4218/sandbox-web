package sandboxweb.demo.controller;

import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/simple-info")
@Slf4j
public class SimpleInfoController {

    @GetMapping("")
    public String index() {
        return "simpleInfo/index";
    }
}
