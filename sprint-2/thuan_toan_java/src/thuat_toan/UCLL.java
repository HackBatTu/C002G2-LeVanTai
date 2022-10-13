package thuat_toan;

import java.util.ArrayList;
import java.util.List;

public class UCLL {
    public static int ucll(int a, int b){
        List<Integer> arrA = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            if(a % i == 0 && b% i == 0){
                arrA.add(i);
            }
        }
        System.out.println(arrA);
        int max = arrA.get(0);
        for (int i = 0; i < arrA.size(); i++) {
            if (max < arrA.get(i)) {
                max = arrA.get(i);
            }
        }
        return max;
    }
    public static void main(String[] arg){
        int a = 4;
        int b = 6;

        System.out.println("ước chung lớn nhất :"+ UCLL.ucll(a,b));

        System.out.println( "bội chung nhỏ nhất :" + (a*b)/UCLL.ucll(a,b));
    }
}
