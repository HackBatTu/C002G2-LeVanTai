package ss8_cleancode_refactoring.thuc_hanh;

import java.util.Scanner;

public class Refactoring {

        public static final char ADDITION = '+';
        public static final char SUBTRACTION = '-';
        public static final char MULTIPLICATION = '*';
        public static final char DIVISION = '/';

        public static int calculate( int firstOperand, int secondOperand,char operator) {
            switch (operator) {
                case ADDITION:
                    return firstOperand + secondOperand;
                case SUBTRACTION:
                    return firstOperand - secondOperand;
                case MULTIPLICATION:
                    return firstOperand * secondOperand;
                case DIVISION:
                    if (secondOperand != 0)
                        return firstOperand / secondOperand;
                    else
                        throw new RuntimeException("Can not divide by 0");
                default:
                    throw new RuntimeException("Unsupported operation");
            }
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the firstOperand : ");
        int firstOperand = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the secondOperand : ");
        int secondOperand = Integer.parseInt(sc.nextLine());

        System.out.print("Enter the char: ");
        char operator = sc.next().charAt(0);

        System.out.println(Refactoring.calculate(firstOperand,secondOperand,operator));

    }
}
