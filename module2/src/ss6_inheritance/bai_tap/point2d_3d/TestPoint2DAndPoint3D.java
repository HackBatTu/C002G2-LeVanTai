package ss6_inheritance.bai_tap.point2d_3d;

public class TestPoint2DAndPoint3D {
    public static void main(String[] args) {
        Point2D t2DPoint=new Point2D(1, 2);
        System.out.print(t2DPoint+"\n");

        Point3D t3DPoint=new Point3D(3, 4,5);
        System.out.print(t3DPoint);

        t2DPoint.setXY(5,6);
        System.out.println(t2DPoint);
        System.out.println(t3DPoint);

        t3DPoint.setXYZ(6,7,8);
        System.out.println(t3DPoint);

        t3DPoint.getXYZ();
        System.out.println(t3DPoint);
    }
}
