package ss3_array.thuc_hanh;

import java.util.Scanner;

public class MinArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array;

        System.out.println("Enter the length : ");
        int size = sc.nextInt();
        array = new int[size];
        for (int i = 0 ; i< size; i++){
            array[i] = (int) (Math.random()*99);
        }
        for (int i=0 ; i<array.length; i++){
            System.out.print(array[i]+"\t");
        }
        int index = minIndex(array);
        System.out.println("The smallest element in the array is: " + array[index]);


    }
    public static int minIndex(int[] array){
        int index = 0;
        for (int i = 0 ; i<array.length; i++){
            if(array[i]<array[index]){
                index = i;
            }
        }
        return index;

    }
}
