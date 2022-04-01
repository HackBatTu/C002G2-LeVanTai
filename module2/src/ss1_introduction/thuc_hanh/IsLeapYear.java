package ss1_introduction.thuc_hanh;

import java.util.Scanner;

public class IsLeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year;
        System.out.println("Enter a year: ");
        year = sc.nextInt();
        boolean isLapYear = false;
//        if(year %4 ==0){
//            if(year %100 == 0){
//                if(year%400 == 0){
//                    isLapYear = true;
//                }
//            }else {
//                isLapYear = true;
//            }
//        }
        boolean isDivisibleBy4 = year % 4 ==0;
        if(isDivisibleBy4){
            boolean isDivisibleBy100 = year%100==0;
            if(isDivisibleBy100){
                boolean isDivisibleBy400 = year%400 == 0;
                if(isDivisibleBy400){
                    isLapYear = true;
                }
            }else {
                isLapYear = true;
            }
        }
        if(isLapYear){
            System.out.printf("%d is a leap year", year);
        }else {
            System.out.printf("%d is not a leap year",year);
        }

    }
}
