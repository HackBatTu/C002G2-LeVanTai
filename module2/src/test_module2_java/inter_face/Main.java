package test_module2_java.inter_face;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("test câu a: ");
        MayTinhCasioFX500 mfx500 = new MayTinhCasioFX500();
        MayTinhVinacal500 mvn = new MayTinhVinacal500();

        System.out.println("nhập a : ");
        double a = sc.nextDouble();
        System.out.println("nhập b : ");
        double b = sc.nextDouble();
        System.out.println(a +"+"+b +" = " +mfx500.cong(a,b));
        System.out.println(a +"*"+b +" = " +mfx500.nhan(a,b));
        System.out.println(a +"/"+b +" = " + mvn.chia(a,b));
        System.out.println(a +"-"+b +" = " + mvn.tru(a,b));

        System.out.println("test câu b : ");
        double[] arr1 = {5,1,2,3,4,5,8,0};
        double[] arr2 = {6,2,7,9,2,4,5};

        SapXepChen chen = new SapXepChen();
        SapXepChon chon = new SapXepChon();

        chen.sapXepTang(arr1);
        for (int i= 0; i<arr1.length ; i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();

        chon.sapXepGiam(arr2);
        for (int i= 0; i<arr2.length ; i++){
            System.out.print(arr1[i] +" ");
        }
        System.out.println();

        System.out.println("test câu c : ");
        PhanMemMayTinh phanMemMayTinh = new PhanMemMayTinh();
        System.out.println(a +"+"+b +" = " +phanMemMayTinh.cong(a,b));
        double[] arr3 ={1,5,7,4,6,2,3};
        chen.sapXepTang(arr3);
        for (int i =0; i< arr3.length; i++){
            System.out.println(arr3[i]+" ");
        }
        System.out.println();


    }
}
