package test_module2_java.inter_face;

public class SapXepChen implements SapXepInterface {
    @Override
    public void sapXepTang(double[] arr) {

        double temp;
       int j ;
        for (int i = 0; i < arr.length; i++) {
            temp=arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j = j + 1;
            }
            arr[j + 1] = temp;
        }
    }

    @Override
    public void sapXepGiam(double[] arr) {
        double temp;
        int j;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] < temp) {
                arr[j + 1] = arr[j];
                j = j + 1;
            }
            arr[j + 1] = temp;
        }

    }
}
