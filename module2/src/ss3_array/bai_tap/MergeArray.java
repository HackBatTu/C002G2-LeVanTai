package ss3_array.bai_tap;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];

        for(int i =0 ; i< arr1.length; i++){
            System.out.print("Enter arr1 element "+ i + ": ");
            arr1[i] = x.nextInt();
        }
        for(int i =0 ; i< arr2.length; i++){
            System.out.print("Enter arr2 element "+ i + ": ");
            arr2[i] = x.nextInt();
        }

        int[] arr3 = new int[arr1.length + arr2.length];
        int j = 0;
        for (int i = 0; i < arr3.length; i++) {
            if (i < arr1.length) {
                arr3[i] = arr1[i];
            } else {
                if (j<arr2.length) {
                    arr3[i] = arr2[j];
                    j++;
                }
            }
        }
        System.out.println("My array 3");
        for (int a : arr3) {
            System.out.print(a);
        }

    }
}
