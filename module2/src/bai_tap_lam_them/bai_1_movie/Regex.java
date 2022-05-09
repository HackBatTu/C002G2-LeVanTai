package bai_tap_lam_them.bai_1_movie;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    static final String REGEX_ID = "^CL-[0-9]{4}$";
    static final String REGEX_NUM = "^[0-9]+$";

    static Scanner sc = new Scanner(System.in);

    public static int getChoice(int choice) {
        boolean check = true;
        while (check) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.err.print("Error!!! Re- choice:  ");
                check = true;
            }
        }
        return choice;
    }

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

    public static String inputID() {
        System.out.print("Enter the ID: ");
        return Regex.regex(sc.nextLine(), REGEX_ID, "Error: id CL-XXXX");
    }

    public static String inputNum() {
        System.out.print("Enter the NumofMovie: ");
        return Regex.regex(sc.nextLine(), REGEX_NUM, "Error: id CL-XXXX");
    }

    public static String regexYear(String input, String regex) {
        boolean check = true;
        while (check) {
            try{
                if (input.matches(regex)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(input, formatter);
                    LocalDate now = LocalDate.now();
                    if (date.isAfter(now)) {
                        check=false;
                    }else {
                        throw new RegexException("ngày tháng phải lớn hơn ngày tháng hiện tại");
                    }
                } else {
                    throw new RegexException("Error: dd/MM/yyyy");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
                input= sc.nextLine();
            }
        }
        return input;
    }

}
