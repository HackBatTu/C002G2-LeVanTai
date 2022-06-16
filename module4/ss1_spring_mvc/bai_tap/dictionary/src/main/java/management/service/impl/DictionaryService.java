package management.service.impl;

import management.service.IDictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class DictionaryService implements IDictionaryService {
    @Override
    public String findDictionary(String str1) {
        String str2;
        switch (str1){
            case "Hello" :
                str2 = "xin chào";
                break;
            case "gà" :
                str2 = "Lê Thị Phương";
                break;
            case "fate" :
                str2 = "Định Mệnh";
                break;
            case "IT":
                str2 = " lập trình viên";
                break;
            default:
                str2 = "nhập cái khác đi con gà này";
                break;
        }
        return str2;
    }
}
