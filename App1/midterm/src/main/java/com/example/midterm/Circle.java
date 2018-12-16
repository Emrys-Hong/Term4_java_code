package com.example.midterm;

public class Circle {
    private double x;
    private double y;
    private double radius;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public Circle() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    boolean contains(double px, double py) {
        return (Math.pow(px-x,2)+Math.pow(py-y, 2)<=radius*radius);
    }

    boolean contains(Circle c) {
        double dis = Math.pow(c.getX()-x, 2) + Math.pow(c.getY()-y, 2);
        dis = Math.pow(dis, 0.5);
        return dis + c.getRadius() <= this.radius;
    }

    boolean overlaps(Circle c) {
        double dis = Math.pow(c.getX()-x, 2) + Math.pow(c.getY()-y, 2);
        dis = Math.pow(dis, 0.5);
        return dis <= c.getRadius() + radius;
    }
}
