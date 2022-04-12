package test_module2_java;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class MiniGameTaiXiu {
    public static void main(String[] args) {
        double taiKhoan = 5000000;
        Scanner sc = new Scanner(System.in);
        Locale lc = new Locale("vi","VN");
        NumberFormat num = NumberFormat.getInstance(lc);

        int choice;
        do{
            System.out.println("$$$$$$$$$---Mời lựa chọn---$$$$$$$$");
            System.out.println("-------------------------------------");
            System.out.println("select 1 to start and any another key to end : ");

            choice = sc.nextInt();
            int choiceTaiXiu;
            if(choice == 1){
                System.out.println("$$$$$$$---START---$$$$$$$");
                System.out.println("$$$---Tài Khoản của bạn : " + num.format(taiKhoan));

                double datCuoc = 0;
                do{
                    System.out.print("$$$---Mời Đặt cược(>0 and <= "+ num.format(taiKhoan)+") : ");
                    datCuoc = sc.nextDouble();
                }while (datCuoc <=0||datCuoc>taiKhoan );


                do{
                    System.out.print("$$$---Choice 1(Tài) or 2(xỉu) : ");
                    choiceTaiXiu = sc.nextInt();
                }while (choiceTaiXiu !=1 && choiceTaiXiu !=2 );

                // tung xúc sắc
                Random xX1 = new Random(); int x1 = xX1.nextInt(6)+1;
                Random xX2 = new Random(); int x2 = xX2.nextInt(6)+1;
                Random xX3 = new Random(); int x3 = xX3.nextInt(6)+1;
                System.out.println("Kết quả là : "+ x1 +" - "+x2 +" - "+ x3 );
                int count = x1+x2+x3;
                if(count == 3 || count == 18){
                    System.out.println("$$$---Kết Qủa Là : " +count +" nhà cái đã thăm ngàn!!!");
                    System.out.println("$$$---Tài Khoản của bạn : " +num.format(taiKhoan));
                }else if(count < 11){
                    System.out.println("$$$---Kết Qủa Là : " +count + "-> Xỉu");
                    if(choiceTaiXiu == 2 ){
                        System.out.println("$$$---You Win : ");
                        taiKhoan +=datCuoc;
                        System.out.println("$$$---Tài Khoản của bạn : " +num.format(taiKhoan));
                    }else {
                        System.out.println("$$$---You Lost : ");
                        taiKhoan -=datCuoc;
                        System.out.println("$$$---Tài Khoản của bạn : " + num.format(taiKhoan));
                    }
                }else if(count < 18){
                    System.out.println("$$$---Kết Qủa Là : " +count + "-> Tài");
                    if(choiceTaiXiu == 1 ){
                        System.out.println("$$$---You Win : ");
                        taiKhoan +=datCuoc;
                        System.out.println("$$$---Tài Khoản của bạn : " +num.format(taiKhoan));
                    }else {
                        System.out.println("$$$---You Lost : ");
                        taiKhoan -=datCuoc;
                        System.out.println("$$$---Tài Khoản của bạn : " + num.format(taiKhoan));
                    }

                }
            }
        }while (choice == 1);
    }
}
