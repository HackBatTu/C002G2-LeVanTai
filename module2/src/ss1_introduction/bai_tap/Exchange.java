package ss1_introduction.bai_tap;

import java.util.Scanner;

public class Exchange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Usa : ");
        double vnd = 23000;
        double usd;
        usd = sc.nextDouble();
        double exChange = usd * 23000;
        System.out.print("Gía Trị VND : " + exChange);
    }
}
