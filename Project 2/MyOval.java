//Chengliang Tan Exercise 2 MyOval.java

package sample;

import javafx.scene.canvas.GraphicsContext;
public class MyOval extends MyShape {
    private double h;
    private double w;
    private boolean filled;
    private double perimeter;
    private double area;


    //constructors______________________________________________________
    public MyOval(){
        super();
        this.setHeight(0);
        this.setWidth(0);
        this.setFilled(false);
        this.perimeter = 0;
        this.area = 0;
    }

    public MyOval(double inX, double inY, double inW, double inH, MyColor inColor, boolean isFilled) {
        super(inX, inY, inColor);
        this.setHeight(inH);
        this.setWidth(inW);
        this.setFilled(isFilled);
        this.perimeter = getPerimeter();
        this.area = getArea();
    }

    //get functions_________________________________________________________

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
        return getX() - (getWidth()/2);
    }

    public double getUpperLeftY(){
        return getY() - (getHeight()/2);
    }

    public double getPerimeter() {
        perimeter = (double)2*Math.PI*Math.sqrt((getHeight() * getHeight() + getWidth() * getWidth()) / 2.0);
        return perimeter;
    }

    public double getArea(){
        area = Math.PI * getHeight() * getWidth();
        return area;
    }

    //set functions__________________________________________________________________

    public void setHeight(double inH) {
        this.h = inH;
    }

    public void setWidth(double inW) {
        this.w = inW;
    }

    public void setFilled(boolean isFilled) {
        this.filled = isFilled;
    }

    //other methods__________________________________________________________________


    @Override
    public String toString() {
        return "axes lengths: " + getHeight() + "," + getWidth() + "\t" + "perimeter: " + getPerimeter() + "\t" + "area: " + getArea() + "\t";
    }


    @Override
    public void draw(GraphicsContext gc){
        if(isFilled()){
            gc.setFill(c);
            gc.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(),getHeight());
        }
        else gc.strokeOval(getUpperLeftX(), getUpperLeftY(), getWidth(),getHeight());

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
        return new MyRectangle(getX(), getY(), getWidth(), getHeight(), MyColor.BLACK, true);
    }

}
