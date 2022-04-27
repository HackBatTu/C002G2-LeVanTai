package casestudy.utils.regex;

import casestudy.utils.regex.AgeException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    static Scanner sc = new Scanner(System.in);
    public static String regex(String scanner, String regex , String error){
        boolean check = true ;
        do {
            if(scanner.matches(regex)){
                check = false;
            }else {
                System.out.println(error);
                scanner = sc.nextLine();
            }
        }while (check);
        return scanner;
    }

    public static String regexAge(String scanner , String regex){
        boolean check = true;
        while (check){
            try {
                if(Pattern.matches(regex,scanner)){
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(scanner,formatter); // ép kiểu nhập theo format
                    LocalDate now = LocalDate.now(); //
                    int current = Period.between(age,now).getYears();
                    if(current<100 && current>18){
                        check = false;
                    }else {
                        throw new AgeException("tuổi phải lớn hơn 18 và bé hơn 100");
                    }

                }else {
                    throw new AgeException("tuổi phải lớn hơn 18 và bé hơn 100");

                }
            }catch (AgeException e){
                System.out.println(e.getMessage());
                scanner = sc.nextLine();
            }
        }
        return scanner;
    }
}
