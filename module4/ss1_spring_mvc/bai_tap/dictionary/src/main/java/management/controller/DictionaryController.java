package management.controller;

import management.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/dictionary")
    public String show(){
        return  "dictionary";
    }

    @GetMapping(value = "/find")
    public String find(@RequestParam String str1 , Model model){
        String str2 =this.iDictionaryService.findDictionary(str1);
        model.addAttribute("str2",str2);
        return "dictionary";

    }

}
