import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhập vào số lượng số mà bạn muốn kiểm tra : ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            if(checkPrime(i)){
                System.out.println(i + ": là số nguyên tố ");
            }
        }
    }
    public static boolean checkPrime(int n){
        boolean check = true ;
        if(n == 0){
            return false;
        }
        for (int i = 2; i < n; i++) {
            if(n % i == 0){
                check = false;
            }
        }return check ;
    }
}
