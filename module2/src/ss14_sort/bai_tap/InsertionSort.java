package ss14_sort.bai_tap;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        int x,j;
        for (int i = 1; i <arr.length ; i++) {
            x= arr[i];
            j=i;
           while ( j>0 && x <arr[j-1] ) {
                arr[j] =arr[j-1];
                j++;
            }
            arr[j]= x;
        }
    }
}
