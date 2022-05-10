package bai_tap_lam_them.bai_2_codegym;

import java.util.Scanner;

public class Regex {

    static Scanner sc = new Scanner(System.in);
    private static final String REGEX_INPUTID = "^BC-[A-Za-z]{4}$";
    private static final String REGEX_VER= "^[0-9]\\.[0-9]$";
    private static final String REGEX_HOURS= "^[0-9][h]$";


    public static String regex(String input, String regex, String error) {
        boolean check = true;
        while (check) {
            if (input.matches(regex)) {
                check = false;
            } else {
                System.out.println(error);
                input = sc.nextLine();
            }
        }
        return input;
    }
    public static String inputID(){
        System.out.println("enter the id: ");
        return Regex.regex(sc.nextLine(),REGEX_INPUTID,"Error:BC-XXXX");
    }
    public static String inputVer(){
        System.out.println("enter the version : ");
        return Regex.regex(sc.nextLine(),REGEX_VER,"Error:I.I");
    }
    public static String inputHours(){
        System.out.println("enter the hours: ");
        return Regex.regex(sc.nextLine(),REGEX_HOURS,"Error:INT(h)");
    }

    public static int getChoice() {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.print("Error!!! Re- choice:  ");
            }
        }
        return choice;
    }
}
