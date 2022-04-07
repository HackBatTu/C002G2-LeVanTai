package ss6_inheritance.bai_tap.point2d_3d;

public class Point2D {
    protected float x = 0.0f;
    protected float y = 0.0f;
    public Point2D(){

    }
    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x,float y){
        this.x = x;
        this.y = y;
    }
    public float[] getXY(){
       float[] array2 = new float[2];
        array2[0]= this.x;
        array2[1]= this.y;
       return array2;
//        float[] array2 = {this.x, this.y}; cách 2 khởi tạo mảng
//        return array2;
    }

    @Override
    public String toString() {
        return "Point2D : \n" +
                "x =" + x +"\n"+
                "y =" + y ;
    }
}
