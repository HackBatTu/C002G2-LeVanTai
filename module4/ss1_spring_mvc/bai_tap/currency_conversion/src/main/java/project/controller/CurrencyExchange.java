package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.service.ICurrencyService;

@Controller
public class CurrencyExchange {
    @Autowired
    private ICurrencyService iCurrencyService;

    @GetMapping("/currency")
    public String show(){
        return "currency";
    }

    @GetMapping(value = "/exchange")
    public String exchange(@RequestParam int usd ,@RequestParam int rate , Model model){

        int vnd = this.iCurrencyService.exchange(usd, rate);
        model.addAttribute("vnd",vnd);
        return "currency";
    }
}
