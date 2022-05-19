package giai_thuat;

import java.util.Arrays;

public class Strings {
    public static void main(String[] args) {
        String str = "abcbdcef";
        String[] arr = str.split("");
        String[] arr1 = new String[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            count = 0;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[i].equals(arr[j])){
                    count++;
                }
            }
            System.out.println(count);
            if(count>1){
                    for (int j = i+1; j < arr.length ; j++) {
                        if(arr[i].equals(arr[j])){
                            arr[i] = arr1[j];
                        }
                }
            }
            System.out.println(Arrays.toString(arr1));
        }

    }
}
