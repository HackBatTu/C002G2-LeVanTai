
import java.util.Scanner;

public class CountStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập vào chuỗi cần đếm kí tự xuất hiện : ");
        String str = sc.nextLine();
        checkStr(str);
    }

    public static void checkStr(String str) {
        int count[] = new int[255];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
            System.out.println(count[str.charAt(i)]);
        }
        char arr[] = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
            int temp = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == arr[j]) {
                    temp++;
                }
            }
            if (temp == 1) {
                System.out.println("Số lần xuất hiện của " + str.charAt(i) + " là :" + count[str.charAt(i)]);
            }
        }
    }
}

