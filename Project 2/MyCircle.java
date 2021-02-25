//Chengliang Tan Exercise 2 MyCircle.java

package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyCircle extends MyOval {
    private double radius;
    private boolean filled;
    private double perimeter;
    private double area;

    //constructors_____________________________________________________________________________
    public MyCircle(){
        super();
        this.setRadius(0.0);
        this.setFilled(false);
        this.perimeter = 0;
        this.area = 0;
    }

    public MyCircle(double inX, double inY, double inRadius, MyColor inColor, boolean isFilled){
        super(inX, inY, inRadius, inRadius, inColor, isFilled);
        this.setRadius(inRadius);
        this.perimeter = getPerimeter();
        this.area = getArea();
    }

    //get functions_______________________________________________________________________________
    public double getRadius() {
        return radius;
    }

    public boolean isFilled() {
        return filled;
    }

    public double getArea(){
        area = Math.PI*(getRadius()*getRadius());
        return area;
    }

    public double getPerimeter(){
        perimeter = 2*Math.PI*getRadius();
        return perimeter;
    }

    public double getUpperLeftX(){
        return getX() - getRadius();
    }

    public double getUpperLeftY(){
        return getY() - getRadius();
    }

    //set functions________________________________________________________________________________
    public void setRadius(double inRadius) {
        this.radius = inRadius;
    }

    public void setFilled(boolean isFilled) {
        this.filled = isFilled;
    }

    //other methods________________________________________________________________________________
    @Override
    public String toString(){
        return "Radius: " + getRadius() + "\t" + "Perimeter: " + getPerimeter() + "\t" + "Area: " + getArea() + "\n";
    }

    @Override
    public void draw(GraphicsContext gc){
        if(isFilled()){
            gc.setFill(c);
            gc.fillOval(getUpperLeftX(), getUpperLeftY(), getRadius()*2, getRadius()*2);
        }
        else gc.strokeOval(getUpperLeftX(), getUpperLeftY(), getRadius(), getRadius());
    }


    @Override
    public double[] getPoint() {
        double point[] = new double[2];
        point[0] = this.getX();
        point[1] = this.getY();
        return point;
    }

    @Override
    public void moveTo(double inX, double inY) {
        this.setX(this.getX()+inX);
        this.setY(this.getY()+inY);
    }

    @Override
    public double distanceTo(double inX, double inY) {
        double distance = Math.sqrt(Math.pow((this.getX()-inX),2)+Math.pow((this.getY()-inY),2));
        return distance;
    }

    @Override
    public MyRectangle getMyBoundingBox() {
        return new MyRectangle(getX(), getY(), getRadius(), getRadius(), MyColor.BLACK, true);
    }

}
