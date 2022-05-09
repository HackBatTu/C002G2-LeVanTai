package Exam.utils;

import java.util.Scanner;

public class Regex {
    static Scanner sc = new Scanner(System.in);
    private static final String REGEX_1 = "^$";
    private static final String REGEX_2 = "^$";

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
//    public static String inputIDVL(){
//        System.out.println("Enter the ID Villa: ");
//        return Regex.regexInput(sc.nextLine(), , "Error: ");
//    }
//    public static String inputIDHO(){
//        System.out.println("Enter the ID House: ");
//        return Regex.regexInput(sc.nextLine(), , "Error: ");
//    }
//    public static String inputIDRO(){
//        System.out.println("Enter the ID Room: ");
//        return Regex.regexInput(sc.nextLine(), , "Error: ");
//    }
    public static int getChoice(int choice) {
        boolean check = true;
        while (check){
            try {
                choice = Integer.parseInt(sc.nextLine());
                check =false;
            } catch (NumberFormatException e) {
                System.err.print("Error: " + e.getMessage());
                System.out.print("-------" + "\n" + "\n"+ "Re-choice: ");
                check = true;
            } catch (Exception e) {
                System.err.println(e.getMessage());
                check =true;
            }
        }
        return choice;
    }
}
