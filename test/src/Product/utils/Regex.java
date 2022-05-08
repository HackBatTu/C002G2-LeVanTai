package Product.utils;

import java.util.Scanner;

public class Regex {
    static Scanner sc = new Scanner(System.in);

    public static int regexChoice(int choice){
        boolean check = true;
        while (check){
            try {
                choice = Integer.parseInt(sc.nextLine());
                check = false;
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
        return choice;
    }
}
