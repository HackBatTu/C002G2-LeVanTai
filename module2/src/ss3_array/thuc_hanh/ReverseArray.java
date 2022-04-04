package ss3_array.thuc_hanh;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        int [] array;
        do{
            System.out.println(" Enter the size: ");
            size = sc.nextInt();
            if(size<10){
                System.out.println("Size do not exceed 20 ");
            }
        }while (size<10);
        array = new int[size];
        for(int i = 0;i<array.length; i++){
            System.out.print("Enter element "+ (i+1)+ ": ");
            array[i]=sc.nextInt();
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for(int i=0 ;i<array.length;i++){
            System.out.print(array[i]+"\t");
        }
        for (int j = 0; j < array.length/2; j++) {
            int temp = array[j];
            array[j] = array[size-j-1];
            array[size-j-1] = temp;
        }
        System.out.printf("\n%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
