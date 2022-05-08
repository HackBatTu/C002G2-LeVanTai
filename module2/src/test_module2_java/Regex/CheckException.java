package test_module2_java.Regex;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CheckException {
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    private static Scanner sc = new Scanner(System.in);
    private static Date now = new Date();
    private final static Long AGE_18_MILISECOND = 567648000000L;
    private final static Long AGE_100_MILISECOND = 3153600000000L;

    public static Date checkExForDate(Date value) {
        boolean check = true;
        while (check) {
            try {
                value = dateFormat.parse(sc.nextLine());
                check = false;
            } catch (ParseException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.println();
                System.out.print("Enter day of birth again! (dd-MM-yyyy): ");
                check = true;
            }
        }
        return value;
    }

    public static Date checkExForDayOfBirth(Date value) {
        boolean check = true;
        while (check) {
            try {
                value = dateFormat.parse(sc.nextLine());
                checkDateEx(value);
                check = false;
            } catch (ParseException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.println();
                System.out.print("Enter day of birth again! (dd-MM-yyyy): ");
            } catch (MyDateException e) {
                System.err.println(e.getMessage());
                System.out.println();
                System.out.print("Enter day of birth again! (dd-MM-yyyy): ");
            }
        }
        return value;
    }

    public static double checkExForParseDouble(double value) {
        boolean check = true;
        while (check) {
            try {
                value = Double.parseDouble(sc.nextLine());
                check = false;

            } catch (NumberFormatException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.print("Enter again: ");
                check = true;

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                check = true;
            }
        }
        return value;
    }

    public static long checkExForParseLong(long value) {
        boolean check = true;
        while (check) {
            try {
                value = Long.parseLong(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.print("Enter again: ");
                check = true;

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                check = true;
            }
        }
        return value;
    }

    public static int checkExForParseInt(int value) {
        boolean check = true;
        while (check) {
            try {
                value = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.print("Enter again: ");
                check = true;

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                check = true;
            }
        }
        return value;
    }

    public static int checkExForChoice(int choice) {
        boolean check = true;
        while (check) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.println();
                System.out.print("Choice again! Your choice: ");
                check = true;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return choice;
    }

    public static void checkDateEx(Date date) throws MyDateException {
        if (!((now.getTime() - date.getTime() < AGE_18_MILISECOND) || (now.getTime() - date.getTime()) > AGE_100_MILISECOND)) {
            throw new MyDateException("Day of birth must be older than 18, younger than 100 years old!");
        }
    }
}
