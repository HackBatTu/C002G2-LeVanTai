package ss6_inheritance.bai_tap.point_moveablepoint;

public class MainTestPoint {
    public static void main(String[] args) {
//        Point point = new Point(1,2);
//        System.out.println(point);

//        point.setXY(3,4);
//        System.out.println(point);
        Point point = new MovablePoint(3,4,5,6);
        point = new MovablePoint(point.getX(), point.getY(),8,7);

        System.out.println(point);

        MovablePoint movablePoint = new MovablePoint(10,11);
        System.out.println(movablePoint);

        movablePoint.getMove();
        System.out.println(movablePoint);

        movablePoint.setXY(10.10f, 20.20f);
        movablePoint.setSpeed(11.11f, 11.11f);

        for (int i = 0; i < movablePoint.getSpeed().length; i++) {
            System.out.println(movablePoint.getSpeed()[i]);
        }

        System.out.println(movablePoint);
        System.out.println(movablePoint.getMove());
    }
}
