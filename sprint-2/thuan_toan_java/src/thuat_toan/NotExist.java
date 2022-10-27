package thuat_toan;

import java.util.Arrays;

public class NotExist {
    public void notDuplicationElement(int[] arr) {
        int arr1[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr1[i] =1;
                    arr1[j] =1;
                }
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,6,2,8, 3, 5, 3, 8, 9, 9, 1};
        NotExist test = new NotExist();
        test.notDuplicationElement(arr);
    }


}
