package ss1_introduction.bai_tap;

import java.util.Scanner;

public class NumberToString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (1 > 0) {
        System.out.print("Enter the num");
        String number = sc.nextLine();

            while (!(number.matches("^[1-9][0-9]?[0-9]$") ||
                    number.matches("^[0-9]$"))) {
                System.out.println("không hợp lệ!");
                System.out.print("nhập số cần đọc (0-999): ");
                number = sc.nextLine();
            }

            String[] arrNumber = number.split("");

            switch (arrNumber.length - 1) {
                case 1:
                    if (arrNumber[1].equals("0")) {
                        System.out.println("zero");
                    } else {
                        System.out.println(tenSlowTen(arrNumber[1]));
                    }
                    break;
                case 2:
                    System.out.println(tenNextTen(arrNumber[1], tenSlowTen(arrNumber[2])));
                    break;
                case 3:
                    if ((arrNumber[2].equals("0")) && (arrNumber[3].equals("0"))) {
                        System.out.println(hunred(arrNumber[1]));
                    } else {
                        System.out.print(hunred(arrNumber[1]));
                        System.out.print( tenNextTen(arrNumber[2], tenSlowTen(arrNumber[3])) + "\n");
                    }
            }
        }

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