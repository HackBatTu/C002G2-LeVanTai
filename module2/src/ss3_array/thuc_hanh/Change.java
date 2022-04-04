package ss3_array.thuc_hanh;

import java.util.Scanner;

public class Change {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        double fah;
        double cel;

        int choice;
        do {
            System.out.println("1. Menu");
            System.out.println("2. fah to cel : ");
            System.out.println("3. cel to fah: ");
            System.out.println("0. Exit");
            System.out.println("Enter you choice: ");
            choice = a.nextInt();

            switch (choice) {
                case 2:
                    System.out.println("Enter the Fah : ");
                    cel = a.nextDouble();
                    fah = (9.0 / 5) * cel + 32;
                    System.out.println("fah to cel " + fah);
                    break;
                case 3:
                    System.out.print("Enter the cel : ");
                    fah = a.nextDouble();
                    cel = (5.0 / 9) * (fah - 32);
                    System.out.println("cel to fah " + cel);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println(" no choice");
                    break;
            }
        }
        while (choice != 0);
    }
}
