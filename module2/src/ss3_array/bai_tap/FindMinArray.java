package ss3_array.bai_tap;

import java.util.Scanner;

public class FindMinArray {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i=0 ; i<arr.length; i++){
            System.out.print(" Enter the element " + i + ": ");
            arr[i] = a.nextInt();
        }
        for(int i=0 ; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        int min = arr[0];
        for (int i =0 ; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        System.out.print("min arr = " + min);
    }
}
