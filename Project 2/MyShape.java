//Chengliang Tan Exercise 2 MyShape.java

package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class MyShape implements MyShapePositionInterface {
    public double x;
    public double y;
    public MyColor color;
    public Color c;


    //constructors_______________________________________________________________
    public MyShape(){
        this.setX(0);
        this.setY(0);
        this.setColor(MyColor.BLACK);
        this.c = Color.BLACK;
    }

    public MyShape(double inX, double inY, MyColor inColor){
        this.setX(inX);
        this.setY(inY);
        this.color = inColor;
        this.c = Color.rgb(color.getRed(), color.getGreen(), color.getBlue(), color.getTrans());
    }


    //get functions__________________________________________________________________
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color getColor() {
        return c;
    }

    //set functions___________________________________________________________________
    public void setX(double inX) {
        this.x = inX;
    }

    public void setY(double inY) {
        this.y = inY;
    }

    public void setColor(MyColor inColor) {
        this.c = Color.rgb(inColor.getRed(),inColor.getGreen(),inColor.getBlue());
    }

    //other methods_____________________________________________________________________

    public String toString() {
        return "x: " + getX() + "\n" + "y: " + getY() + "\n" + "color: " + getColor() + "\n";
    }

    public abstract void draw(GraphicsContext gc);

    @Override
    public void moveTo(double inX, double inY) {
        this.setX(this.getX()+inX);
        this.setY(this.getY()+inY);
    }

    @Override
    public abstract double distanceTo(double inX, double inY);

    public abstract MyRectangle getMyBoundingBox();




}
