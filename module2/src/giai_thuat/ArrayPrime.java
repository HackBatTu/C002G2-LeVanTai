package giai_thuat;

import java.util.ArrayList;
import java.util.List;

public class ArrayPrime {
    public static boolean checkPrime(int number){
        if(number< 2 ){
            return false;
        }
        for (int i=2; i<=Math.sqrt(number) ; i++){
            if(number%i==0){
                return false;
            }
        }
       return true;
    }

    public static int[] solution(int[][] arrs) {
        List<Integer> list = new ArrayList<>();
        int[] arr2 = new int[];

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                if (checkPrime(arrs[i][j])) {
                    list.add(arrs[i][j]);
                }
            }
        }


        return arr2;
    }
    public static void main(String[] args) {
        int[][] arr =new int[4][4];
        for (int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i].length; j++) {
                arr[i][j] = (int)(Math.random()*99);
            }
        }
        solution(arr);

    }

}

