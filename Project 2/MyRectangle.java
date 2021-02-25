//Chengliang Tan Exercise 2 MyRectangle.java

package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyRectangle extends MyShape {
    private double h;
    private double w;
    private boolean filled;
    private double perimeter;
    private double area;

    //constructors
    public MyRectangle(){
        super();
        this.setHeight(0);
        this.setWidth(0);
        this.setFilled(false);
        this.perimeter = 0;
        this.area = 0;
    }

    public MyRectangle(double inX, double inY, double inW, double inH, MyColor inColor, boolean isFilled){
        super(inX, inY, inColor);
        this.setHeight(inH);
        this.setWidth(inW);
        this.setFilled(isFilled);
        this.perimeter = getPerimeter();
        this.area = getArea();
    }

    //get functions____________________________________________________________
    public double getHeight() {
        return h;
    }

    public double getWidth() {
        return w;
    }

    public boolean isFilled() {
        return filled;
    }

    public double getUpperLeftX(){
        return x - (w/2.0); //x - (w/2)
    }

    public double getUpperLeftY(){
        return y - (h/2.0); //y + (h/2)
    }

    public double getPerimeter(){
        perimeter = 2*h + 2*w;
        return perimeter;
    }

    public double getArea(){
        area = h*w;
        return area;
    }

    //set functions____________________________________________________________
    public void setHeight(double h) {
        this.h = h;
    }

    public void setWidth(double w) {
        this.w = w;
    }

    public void setFilled(boolean isFilled) {
        this.filled = isFilled;
    }

    //other methods____________________________________________________________
    @Override
    public String toString() {
        return "width: " + getWidth() + "\t" + "height: " + getHeight() + "\t" + "perimeter: " + getPerimeter() + "\t" + "area: " + getArea() + "\n";
    }


    @Override
    public void draw(GraphicsContext gc){
        if(isFilled()){
            gc.setFill(c);
            gc.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(),getHeight());
        }
        else gc.strokeRect(getUpperLeftX(), getUpperLeftY(), getWidth(),getHeight());

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
        return null;
    }


}
