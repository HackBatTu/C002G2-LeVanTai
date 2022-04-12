package test_module2_java.inter_face;

public class MayTinhCasioFX500 implements MayTinhBoTuiInterface{
    public MayTinhCasioFX500() {
        super();
    }

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
}
