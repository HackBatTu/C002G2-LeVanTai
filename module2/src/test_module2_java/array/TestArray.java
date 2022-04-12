package test_module2_java.array;

import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        // khai báo mảng :
//        int[] arr = {1,2,3};
//        int[] arr = new int[];
//        int arr[]= new int[]{1,2,3};

        // sao chép(coppy) mảng
        // hàm System.arraycopy(mảng gốc, stt ,mảng coppy, stt, mảng gốc.length): coppy từ vtri này -vtri kia
        // Hàm clone() : arr = arr1.clone();

        int[] arr = {1,2,3};
        int[] arr1 = arr;
        arr1[0] = 100;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = arr.clone();
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[arr1.length];
        System.arraycopy(arr1, 0,arr3,0,arr1.length);
        System.out.println(Arrays.toString(arr3));


    }
}
