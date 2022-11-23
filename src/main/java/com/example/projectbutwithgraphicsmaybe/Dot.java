package com.example.projectbutwithgraphicsmaybe;

public class Dot {
    private double dist, angle;
    private Point center;

    Dot(double x, double y, Point center) {
        this.center = center;
        angle = ((x >= center.x ? Math.PI*2 : Math.PI) + Math.atan((y - center.y)/(x - center.x))) % (Math.PI*2);
        dist = Math.sqrt(Math.pow(x - center.x, 2) + Math.pow(y - center.y,  2));
    }

    public void rotate(double a) {
        angle += Math.toRadians(a);
    }

    public void extend(double b) {
        dist += b;
    }

    public double getX() {
        return Math.cos(angle) * dist + center.x;
    }
    public double getY() {
        return Math.sin(angle) * dist + center.y;
    }
}
