package thuat_toan;

public class MaxTwo {

    public static void getMax(int arr[]) {
        int max1 = arr[0];
        int max2 = 0;
        int max3=0;
        for (int i = 0; i < arr.length; i++) {
            if(max1 < arr[i]){
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            }
            if(max3< arr[i] && max2<arr[i]  && arr[i]< max1){
                max2 = arr[i];
            }

            if(max3< arr[i] && arr[i]< max2){
                max3 = arr[i];
            }
        }
        System.out.println("max1 = "+max1);
        System.out.println("max2 = "+max2);
        System.out.println("max3 = "+max3);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,6,6,0,1,5,5,6,7};
        MaxTwo.getMax(arr);
    }
}
