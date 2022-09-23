package thuat_toan;

import java.util.Scanner;

public class CountNumberN {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("nhập vào số n: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = {1,2,3,4,5,6,7,8,9,10,12,15,22};

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i] + arr[j] == n){
                    System.out.println("vị trí 2 số trong mảng có tổng bằng số nhập là : " + i +","+ j);
                    break;
                }
            }
        }

    }
}
