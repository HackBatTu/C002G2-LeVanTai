package ss3_array.thuc_hanh;

import java.util.Scanner;

public class FindMaxValue {
    public static void main(String[] args) {
        int[] array;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The length:");
        int size = sc.nextInt();
        array = new int[size];

        for(int i = 0; i< array.length; i++){
            System.out.print("Enter element "+ i + ":");
            array[i]= sc.nextInt();
        }

        for (int i=0 ; i<array.length; i++){
            System.out.print(array[i]+"\t");
        }
        int max = 0;
        int index = 0;
        for (int i=0 ; i<array.length; i++){
            if (array[i]>max){
                max = array[i];
                index = i;
            }
        }System.out.println("The largest property value in the list is " + max + " ,at position " + index);
    }
}
