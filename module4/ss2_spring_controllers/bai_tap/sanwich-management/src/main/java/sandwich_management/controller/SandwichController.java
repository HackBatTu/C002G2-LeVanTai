package sandwich_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sandwich_management.service.ISandwichService;

@Controller
public class SandwichController {

    @Autowired
    private ISandwichService iSandwichService;

    @RequestMapping("/")
    public String showCondiment() {
        return "index";
    }

    @GetMapping(path = "/save")
    public String saveCondiment(@RequestParam String condiment, ModelMap modelMap) {
        modelMap.addAttribute("condiment", condiment);
        return "index";
    }

}
