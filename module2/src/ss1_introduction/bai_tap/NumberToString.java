package ss1_introduction.bai_tap;

import java.util.Scanner;

public class NumberToString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the num");
        int num = sc.nextInt();

        String str;
        switch (num){
            case "0":
                 return " ";
            case "1":
                return "one";
            case 2:
                str = "two";
            case 3:
                str = "three";
            case 4:
                str = "four";
            case 5:
                str = "five";
            case 6:
                str = "six";
            case 7:
                str = "seven";
            case 8:
                str = "eight";
            case 9:
                str = "night";
            default:
                str = "out of ability";

        }
        System.out.print(" dãy số là : " + str);
    }
}
