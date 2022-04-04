package ss3_array.bai_tap;

import java.util.Scanner;

public class CountCow {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter size Col: ");
        int c = s.nextInt();
        System.out.print("Enter size Row: ");
        int r = s.nextInt();

        int[][] arr = new int[c][r];

        for(int i =0 ; i<arr.length; i++){
            for (int j = 0 ; j<arr[i].length; j++){
                System.out.print("Enter element Col " + i + " Row " + j + ": ");
                arr[i][j] = s.nextInt();
            }
        }
        for(int i =0 ; i<arr.length; i++){
            for (int j = 0 ; j<arr[i].length; j++){
                System.out.print(arr[i][j]+ "\t");
            }
            System.out.println();
        }

        System.out.println("Enter element index  : ");
        int index = s.nextInt();

        int sum = 0;
        for (int i = 0; i < arr[index].length; i++) {
            sum += arr[index][i];
        }
        System.out.println("Sum of element with index = " + index + ": " + sum);
    }
}
