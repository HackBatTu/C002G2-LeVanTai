package Exam.utils;

import java.util.Scanner;

public class Regex {
    static Scanner sc = new Scanner(System.in);
    private static final String REGEX_INT = "^[0-9][0-9]{1,}$";
    private static final String REGEX_YEAR = "^[0-9][1-9]{1}|[0-6][0-9][0-9]|[7][0-2][0-9]$";


    public static String regexInput(String input, String regex, String error) {
        boolean check = true;
        do {
            if (input.matches(regex)) {
                check = false;
            } else {
                System.err.println(error);
                input = sc.nextLine();
            }
        } while (check);
        return input;
    }
    public static String inputInt(){
        return Regex.regexInput(sc.nextLine(), REGEX_INT, "định dạng là số dương");}

    public static String inputYear(){
        System.out.print("Nhập thời gian bảo hành: ");
        return Regex.regexInput(sc.nextLine(), REGEX_YEAR, "định dạng là số dương nhỏ hơn 730");}

    public static int checkParseInt() {
        int choice;
        while (true){
            try {
                choice = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.print("Error: " + e.getMessage());
                System.out.print("Re-choice: ");
            }
        }
        return choice;
    }
}
