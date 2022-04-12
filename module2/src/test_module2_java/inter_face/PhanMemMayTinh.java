package test_module2_java.inter_face;

public class PhanMemMayTinh implements MayTinhBoTuiInterface, SapXepInterface{
    @Override
    public double cong(double a, double b) {
        return a+b;
    }

    @Override
    public double tru(double a, double b) {
        return a-b;
    }

    @Override
    public double nhan(double a, double b) {
        return a*b;
    }

    @Override
    public double chia(double a, double b) {
        return a/b;
    }

    @Override
    public void sapXepTang(double[] arr) {
        int n = arr.length;
        double temp;
        int i, j;
        for (i = 0; i < n; i++) {
            temp = arr[i];
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
        int n = arr.length;
        double temp;
        int i, j;
        for (i = 0; i < n; i++) {
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
