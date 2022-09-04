import java.util.Scanner;

public class CountPrime {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.print("nhập vào số lượng số cần tính tổng số nguyên tố: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            if(checkPrime(i)){
                count += i;
                System.out.println(  i + " là số nguyên tố");
            }
        }
        System.out.println("tổng các số nguyên tố trong "+ n +" số là : "+ count);
    }

    public static boolean checkPrime(int n){
        boolean check = true;
        if(n == 0){
            return false;
        }
        for (int i = 2; i < n; i++) {
            if(n % i == 0){
                check = false;
            }
        }  return check;
    }
}
