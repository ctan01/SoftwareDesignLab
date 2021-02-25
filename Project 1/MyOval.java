//Chengliang Tan Exercise 1 MyOval.java

package sample;

import javafx.scene.canvas.GraphicsContext;
public class MyOval extends MyShape {
    private double h;
    private double w;
    private boolean filled;

    //constructors______________________________________________________
    public MyOval(){
        super();
        this.setHeight(0);
        this.setWidth(0);
        this.setFilled(false);
    }

    public MyOval(double inX, double inY, double inW, double inH, MyColor inColor, boolean isFilled) {
        super(inX, inY, inColor);
        this.setHeight(inH);
        this.setWidth(inW);
        this.setFilled(isFilled);
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
        return x - (w/2);
    }

    public double getUpperLeftY(){
        return y - (h/2);
    }

    public double GetPerimeter() {
        return (double)2*Math.PI*Math.sqrt((h*h+w*w)/2.0);
    }

    public double getArea(){
        return Math.PI * h * w;
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
        return "axes lengths: " + getHeight() + "," + getWidth() + "\n" + "perimeter: " + GetPerimeter() + "\n" + "area: " + getArea() + "\n";
    }


    @Override
    void draw(GraphicsContext gc){
        /*Canvas canvas = new Canvas(400,600);
        GraphicsContext gc = canvas.getGraphicsContext2D();*/
        if(isFilled()){
            gc.setFill(c);
            gc.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(),getHeight());
        }
        else gc.strokeOval(getUpperLeftX(), getUpperLeftY(), getWidth(),getHeight());

    }
    /*@Override
    public void draw(GraphicsContext gc) {
        g.setColor(getColor());
        if(isFilled()){
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
        else g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
    }*/
}
