package ss6_inheritance.bai_tap.point_moveablepoint;

public class MovablePoint extends Point {
   private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint() {

    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] speed = new float[2];
        speed[0] = this.xSpeed;
        speed[1] = this.ySpeed;
        return speed;
//        float[] speed = {this.xSpeed, this.ySpeed}; cách 2 khởi tạo mảng
//        return speed;
    }

    public MovablePoint getMove() {
        this.setX(this.getX() + this.xSpeed);
        this.setY(this.getY() + this.ySpeed);
        return this;
    }

    @Override
    public String toString() {
        return "MovablePoint: " + "\n" +
                "xSpeed=" + xSpeed + "\n" +
                "ySpeed=" + ySpeed + "\n" +
                "x=" + this.getX()+ "\n" +
                "y=" + this.getY();
    }

}
