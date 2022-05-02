package casestudy.utils.regex;

import casestudy.utils.regex.AgeException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    static Scanner sc = new Scanner(System.in);
    private static final String REGEX_ID_VL = "^SVVL-[0-9]{4}$";
    private static final String REGEX_ID_HO = "^SVHO-[0-9]{4}$";
    private static final String REGEX_ID_RO = "^SVRO-[0-9]{4}$";
    private static final String REGEX_NAME = "^[A-Z][a-z0-9 ]+$";
    private static final String REGEX_PERSON = "^[1-9]|([1][0-9])|(20)$";
    private static final String REGEX_AREA = "^((([3-9]\\d)|([1-9]\\d\\d+))\\.\\d{1,})$";
    private static final String REGEX_INT = "^(1-9)|([1][0-9]+)$";

    public static String regex(String scanner, String regex, String error) {
        boolean check = true;
        do {
            if (scanner.matches(regex)) {
                check = false;
            } else {
                System.err.println(error);
                scanner = sc.nextLine();
            }
        } while (check);
        return scanner;
    }

    public static String inputIDVL(){System.out.println("Enter the ID Villa: ");
        return Regex.regex(sc.nextLine(), REGEX_ID_VL, "Error: id dạng SVVL-XXXX");}
    public static String inputIDHO(){System.out.println("Enter the ID House: ");
        return Regex.regex(sc.nextLine(), REGEX_ID_HO, "Error: id dạng SVHO-XXXX");}
    public static String inputIDRO(){System.out.println("Enter the ID Room: ");
        return Regex.regex(sc.nextLine(), REGEX_ID_RO, "Error: id dạng SVRO-XXXX");}
    public static String inputName(){System.out.println("Enter the service Name Villa: ");
        return Regex.regex(sc.nextLine(), REGEX_NAME, "Error: name có chữ hoa đầu");}
    public  static String inputArea(){System.out.println("Enter the Area House : ");
        return Regex.regex(sc.nextLine(), REGEX_AREA, "Error: Area >30m2");}
    public  static String inputRentalCost(){System.out.println("Enter the rental cost House: ");
        return Regex.regex(sc.nextLine(), REGEX_INT, "Error: cost là số dương");}
    public  static String inputMaxPerson(){System.out.println("Enter the Max Person : ");
        return Regex.regex(sc.nextLine(), REGEX_PERSON, "Error: 1< person <20");}
    public static String inputRentalType(){System.out.println("Enter the rental Type House: ");
        return Regex.regex(sc.nextLine(), REGEX_NAME, "Error: type có chữ hoa đầu");}
    public static String inputRoomStandard(){System.out.println("Enter the room standard House: ");
        return Regex.regex(sc.nextLine(), REGEX_NAME, "Error: standard có chữ hoa đầu");}
    public static String inputPoolArea(){System.out.println("Enter the poolArea : ");
        return Regex.regex(sc.nextLine(), REGEX_AREA, "Area >30m2");}
    public static String inputNumOfFloors(){System.out.println("Enter the num of floors : ");
        return Regex.regex(sc.nextLine(), REGEX_INT, "Error: NumOfFloors: là số dương");}
    public static String inputFreeService(){System.out.println("Enter the Free service House: ");
        return Regex.regex(sc.nextLine(), REGEX_NAME, "Error: Free Service có chữ hoa đầu");}

    public static String regexAge(String scanner, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, scanner)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(scanner, formatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getYears();
                    if (current < 100 && current > 18) {
                        check = false;
                    } else {
                        throw new AgeException("Error: 100< age <18 and dd/MM/yyyy .");
                    }
                } else {
                    throw new AgeException("Error: 100< age <18 and dd/MM/yyyy .");
                }
            } catch (AgeException e) {
                System.err.println(e.getMessage());
                scanner = sc.nextLine();
            }
        }
        return scanner;
    }

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
