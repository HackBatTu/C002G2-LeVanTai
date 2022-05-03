package casestudy_module2.util;

import java.util.Scanner;

public class Regex {
    static Scanner sc = new Scanner(System.in);

    public static int regexChoice(int choice) {
        boolean check = true;
        while (check) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                check = true;
            } catch (Exception e) {
                System.err.println(e.getMessage());
                check = true;
            }
        }
        return choice;
    }
}
