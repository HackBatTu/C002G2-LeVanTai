package giai_thuat;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,6};

        System.out.println(Test.solution(arr));
    }

    public static boolean solution(int[] arr) {
        boolean flag = false;
        int sum1 = 0;
            for (int i = 1; i < arr.length; i++) {
                sum1 += arr[i-1];
                int sum2 = 0;
                for (int j = (i + 1); j < arr.length; j++) {
                    sum2 += arr[j];
                }
                if (sum1 == sum2) {
                    flag = true;
                    break;
                }
            }

        return flag;
    }
}
