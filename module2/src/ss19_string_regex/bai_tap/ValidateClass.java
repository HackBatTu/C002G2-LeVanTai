package ss19_string_regex.bai_tap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    private static final String REGEX_CLASS = "^[CAP]+[0-9]{4}+[GHIKLM]$";
//    private static final String REGEX_CLASS = "^[C|A|P]+\d{4}+[G|H|I|K|L|M]$";

    public ValidateClass() {
    }


    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX_CLASS);
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("enter the string you want regex: ");
            String str = sc.nextLine();
            if(p.matcher(str).find()){
                System.out.println("hợp lệ");
                break;
            }else{
                System.out.println("không hợp lệ");
            }
        }
    }
}

