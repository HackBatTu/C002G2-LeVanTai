package ss6_inheritance.bai_tap.point2d_3d;

public class Point3D extends Point2D{
    private float z = 0.0f;

    public Point3D(){

    }
    public Point3D(float z) {
        this.z = z;
    }
    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }
    public float getZ() {
        return z;
    }
    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x , float y ,float z){
        setXY(x,y);
        this.z =z;
    }
    public float[] getXYZ(){
        float[] array3 = new float[3];
        array3[1] = this.x;
        array3[2] = this.y;
        array3[3] = this.z;
        return array3;
//        float[] array3 = {super.getX(), super.getY(), this.z}; cách 2 khởi tạo mảng
//        return array3;
    }

    @Override
    public String toString() {
        return "Point3D : " +"\n"+
                "z = " + z +"\n"+
                super.toString()+ "\n";
    }
}
