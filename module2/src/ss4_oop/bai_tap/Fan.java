package ss4_oop.bai_tap;

public class Fan {
    private final int slow = 1;
    private final int medium = 2;
    private final int fast =3;
    private int speed = slow ;
    private double radius = 5;
    private String color = "blue";
    private boolean on = false;

    public Fan(){

    }
    public Fan(int speed, double radius ,String color, boolean on ) {
        this.speed = speed;
        this.radius = radius;
        this.color = color;
        this.on = on;
    }
    public int getSlow() {
        return slow;
    }
    public int getMedium() {
        return medium;
    }
    public int getFast() {
        return fast;
    }
    public int getSpeed(){
        return speed;
    }
    public boolean getOn(){
        return on;
    }
    public double getRadius(){
        return radius;
    }
    private String color(){
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public String toString() {
        String str = "";
        if (this.getOn()) {
            str += ("Fan is on\n");
            str += ("Speed: " + this.speed + "\n");
        } else {
            str += ("Fan is off");
        }
        str += ("Color: " + this.color + "\n");
        str+= ("Radius: " + this.radius + "\n");
        return str;
    }
}
