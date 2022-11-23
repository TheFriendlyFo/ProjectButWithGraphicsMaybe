package com.example.projectbutwithgraphicsmaybe;

public class Dot {
    private double dist, angle;
     Point center, location;

    Dot(double x, double y, Point center) {
        this.center = center;
        this.location = new Point(x, y);
        angle = ((x >= center.x ? Math.PI*2 : Math.PI) + Math.atan((y - center.y)/(x - center.x))) % (Math.PI*2);
        dist = Math.sqrt(Math.pow(x - center.x, 2) + Math.pow(y - center.y,  2));
    }

    public void rotate(double a) {
        angle += Math.toRadians(a);
        update();
    }

    public void extend(double b) {
        dist += b;
        update();
    }

    public void update() {
        location.set(Math.cos(angle) * dist + center.x,
                Math.sin(angle) * dist + center.y);
    }

    public double getX() {
        return location.x;
    }
    public double getY() {
        return location.y;
    }
}
