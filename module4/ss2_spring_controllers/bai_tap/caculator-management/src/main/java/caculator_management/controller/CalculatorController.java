package caculator_management.controller;

import caculator_management.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService iCalculatorService;

    @RequestMapping("/")
    public String showCalculator() {
        return "index";
    }

    @PostMapping(path = "/link")
    public String calculation(ModelMap modelMap, @RequestParam double number1 , @RequestParam double number2, @RequestParam String operator){

        if (operator.equals("division(/)") && number2 == 0) {
            modelMap.put("reviews", "Số " + number1 + " không được phép chia cho 0");
        } else {
            modelMap.put("result", this.iCalculatorService.calculator(number1, number2, operator));
        }return "index";
    }
}
