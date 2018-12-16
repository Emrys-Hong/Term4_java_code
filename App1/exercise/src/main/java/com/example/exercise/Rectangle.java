package com.example.exercise;

public class Rectangle extends GeometricObject implements Comparable<Rectangle>{
    private double width;
    private double height;

    public double getArea() {
        return width*height;
    }

    double getPerimeter() {
        return (width+height)*2;
    }
    // for constructor you can also do this. it is the same as "Rectangle1"
    // we use this, we can only fix the one that is more powerful and then the rest will be automatically fixed.
    // in another way: we have a centralized constructor.
    // this is to call the constructor of the same class.
    Rectangle() {
//        super(); // this calls the super class's constructor, so it execute its content.
//        super() is redundant. as the constructor will automatically call the super no arg constructor in the superclass.
        // GeoObject(); is not allowed to call.
        // GeoObject() must be called with new operator; and then it calls the constructor;
        // new GeoObject also not correct. because it will call a new object.
        this(1, 1);
    }

//    Rectangle1() {
//        this.width = this.height = 1;
//    }

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int compareTo(Rectangle r){
        if(this.height > r.height){
            return 1;
        }else if(this.height == r.height){
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public String toString(){
        return "height" + this.height + "width" + this.width;
    }
}
