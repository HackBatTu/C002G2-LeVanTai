package ss6_inheritance.bai_tap.point_moveablepoint;

public class Point {
    protected float x = 0.0f;
    protected float y = 0.0f;
    public Point(){

    }
    public Point(float x, float y) {
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
        float[] point = new float[2];
        point[0]= this.x;
        point[1]= this.y;
        return point;
//        float[] point = {this.x, this.y}; khởi tạo mảng
//        return point;
    }

    @Override
    public String toString() {
        return "Point : \n" +
                "x =" + x +"\n"+
                "y =" + y ;
    }
}
