package ss3_array.bai_tap;



import java.util.Scanner;

public class FindArrayMaxElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length : ");
        int a = sc.nextInt();
        System.out.print("Enter the element : ");
        int b = sc.nextInt();

        int[][] arr = new int[a][b];
        for(int i =0 ; i<arr.length; i++){
            for (int j = 0 ; j<arr[i].length; j++){
                arr[i][j] = (int)(Math.random()*99);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0 ; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]>max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println("Max: " + max);
    }
}
