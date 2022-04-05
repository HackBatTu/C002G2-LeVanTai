package ss3_array.bai_tap;

import java.util.Scanner;

public class CountCheo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" enter the size : ");
        int size = sc.nextInt();
        int[][] arr = new int[size][size];

        for (int i= 0 ; i< arr.length; i++){
            for (int j = 0 ; j< arr[i].length; j++){
                arr[i][j] = (int)(Math.random()*99);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int sum =0;
        for (int i= 0 ; i< arr.length; i++){
            for (int j = 0 ; j< arr[i].length; j++){
                if(i == j){
                    sum += arr[i][j];
                }
            }

        }   System.out.print("Tổng đường chéo là : " + sum);
    }
}
