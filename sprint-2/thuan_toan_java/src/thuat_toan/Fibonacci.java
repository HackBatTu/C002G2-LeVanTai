package thuat_toan;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhập vào giá trị giới hạn của dãy số: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; checkFibonacci(i) < n; i++) {
            System.out.print(checkFibonacci(i) + ", ");
        }
    }

    public static int checkFibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return checkFibonacci(n - 1) + checkFibonacci(n - 2);
    }
}
