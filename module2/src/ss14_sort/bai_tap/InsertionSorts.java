package ss14_sort.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSorts {
    public static void insertionSort(int[] arr){
        int x,j;
        for (int i = 1; i <arr.length ; i++) {
            x= arr[i];
            j=i;
            while ( j>0 && x <arr[j-1] ) {
                arr[j] =arr[j-1];
                j++;
            }
            arr[j]= x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size : ");
        int size = Integer.parseInt(sc.nextLine());
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*99);
            System.out.println(arr[i]);
        }
        System.out.println("-------");


    }
}
