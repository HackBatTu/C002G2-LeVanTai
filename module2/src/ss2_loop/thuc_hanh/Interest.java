package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter tiền gửi");
        double money = sc.nextDouble();
        System.out.print("Enter lãi suất tháng");
        double interestRate = sc.nextDouble();
        System.out.print("Enter số tháng gửi");
        int month = sc.nextInt();
        double interest = 0;
        for(int i=0 ; i<month ; i++) {
            interest += money * (interestRate/100) / 12 * month;
        }
        System.out.println("số tiền lãi là : "+ interest);

    }
}
