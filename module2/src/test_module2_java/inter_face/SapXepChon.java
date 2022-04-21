package test_module2_java.inter_face;

public class SapXepChon implements SapXepInterface {
    @Override
    public void sapXepTang(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            double temp = arr[i];
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                    arr[min] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    @Override
    public void sapXepGiam(double[] arr) {
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[min]) {
                    min = j;
                    double temp = arr[min];
                    arr[min] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
