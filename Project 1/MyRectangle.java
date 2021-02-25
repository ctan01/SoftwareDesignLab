//Chengliang Tan Exercise 1 MyRectangle.java

package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyRectangle extends MyShape {
    public double h;
    public double w;
    public boolean filled;

    //constructors
    public MyRectangle(){
        super();
        this.setHeight(0);
        this.setWidth(0);
        this.setFilled(false);
    }

    public MyRectangle(double inX, double inY, double inW, double inH, MyColor inColor, boolean isFilled){
        super(inX, inY, inColor);
        this.setHeight(inH);
        this.setWidth(inW);
        this.setFilled(isFilled);
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
        return 2*h + 2*w;
    }

    public double getArea(){
        return h*w;
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
        return "width: " + getWidth() + "\n" + "height: " + getHeight() + "\n" + "perimeter: " + getPerimeter() + "\n" + "area: " + getArea() + "\n";
        //return super.toString();
    }


    @Override
    void draw(GraphicsContext gc){
        /*Canvas canvas = new Canvas(400,600);
        GraphicsContext gc = canvas.getGraphicsContext2D();*/
        if(isFilled()){
            gc.setFill(c);
            //MyColor.getColor()
            gc.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(),getHeight());
        }
        else gc.strokeRect(getUpperLeftX(), getUpperLeftY(), getWidth(),getHeight());



    }
    /*@Override
    public void draw(Graphics g){
        g.setColor(getColor());
        if(isFilled()){
            g.fillRect(getUpperLeftX(), getUpperLeftY(), getHeight(), getWidth());
        }
        else g.drawRect(getUpperLeftX(), getUpperLeftY(), getHeight(), getWidth());
    }*/
}
