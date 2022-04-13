package ss8_cleancode_refactoring.thuc_hanh;

import java.util.Scanner;

public class RefactoringFizzBuzz {
    public static String fizzBuzz(int number) {
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;

        if (isFizz && isBuzz)
            return "FizzBuzz";

        if (isFizz)
            return "Fizz";

        if (isBuzz)
            return "Buzz";

        return number + "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number : ");
        int number = sc.nextInt();
        RefactoringFizzBuzz.fizzBuzz(number);
        System.out.println(fizzBuzz(number));
    }
}
