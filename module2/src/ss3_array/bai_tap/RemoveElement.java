package ss3_array.bai_tap;

import java.util.Scanner;

public class RemoveElement {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        System.out.print("Enter the length: ");
        int size = a.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 99);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("Enter the X : ");
        int x = a.nextInt();

        boolean check = true;

        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                check = true;
                break;
            }
        }
        if (check) {
            for (int i = x; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
        }
        arr[arr.length-1] = 0;
        System.out.println("New arr: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
