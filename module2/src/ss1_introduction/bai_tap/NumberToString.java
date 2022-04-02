package ss1_introduction.bai_tap;

import java.util.Scanner;

public class NumberToString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the num");
        String number = sc.nextLine();

    }
    private static String tenSlowTen(String number) {
        switch (number) {
            case "0":
                return "";
            case "1":
                return "one";
            case "2":
                return "two";
            case "3":
                return "three";
            case "4":
                return "four";
            case "5":
                return "five";
            case "6":
                return "six";
            case "7":
                return "seven";
            case "8":
                return "eight";
            case "9":
                return "nine";
            default:
                return "out of ability";
        }
    }
    private static String tenNextTen(String number, String nextTen) {
        switch (number) {
            case "0":
                return nextTen;
            case "1":
                switch (nextTen) {
                    case "":
                        return "ten";
                    case "one":
                        return "eleven";
                    case "two":
                        return "twelve";
                    case "three":
                        return "thirdteen";
                    default:
                        return nextTen + "teen";
                }
            case "2":
                return "twenty " + nextTen;
            case "3":
                return "thirdty " + nextTen;
            default:
                return tenSlowTen(number) + "ty" + " " + nextTen;

        }
    }
    private static String hunred(String number) {
        return tenSlowTen(number) + " hunred";
    }
}
