package ss3_array.bai_tap;

import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        System.out.print("Enter the length: ");
        int size = a.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 99);
            System.out.print(arr[i] + "\t");
        }

        System.out.println("Enter the X : ");
        int x = a.nextInt();
        System.out.println("Enter the index : ");
        int index = a.nextInt();

        if(index <= -1 && index >= arr.length-1){
            System.out.println("Cant add ");
        }else{
            for(int i=arr.length-1 ;i>index ;i--) {
                 arr[i]= arr[i-1];
            }
            arr[index] = x;
        }

        for(int i = 0 ; i< arr.length; i++){
            System.out.print(arr[i] + ",");
        }


    }
}
