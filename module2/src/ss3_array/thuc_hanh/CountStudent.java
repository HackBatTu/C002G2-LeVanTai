package ss3_array.thuc_hanh;

import java.util.Scanner;

public class CountStudent {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter size: ");
            size = scanner.nextInt();
            if (size > 30)
                System.out.println("Size should not exceed 30");
        } while (size > 30);

        array = new int[size];
       for(int i = 0; i<array.length;i++){
            System.out.print("Enter a mark for student " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        int count = 0;
        System.out.print("List of mark: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
            if (array[i] >= 5 && array[i] <= 10)
                count++;
        }
        System.out.print("\nThe number of students passing the bai_tap_lam_them.exam is " + count);
    }
}
