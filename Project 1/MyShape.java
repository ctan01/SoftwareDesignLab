//Chengliang Tan Exercise 1 MyShape.java

package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyShape {
    public double x;
    public double y;
   // public Color c = Color.rgb(color.getRed(),  );
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
        this.c = Color.rgb(color.getRed(), color.getGreen(), color.getBlue());
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
        this.color = inColor;
    }

    //other methods_____________________________________________________________________

    public String toString() {
        return "x: " + getX() + "\n" + "y: " + getY() + "\n" + "color: " + getColor() + "\n";
        //return String.format("(x,y): (%d,%d)\n Color: () " ,this.getX(), this.getX());
    }

    void draw(GraphicsContext gc) {
        /*Canvas canvas = new Canvas(400,600);
        GraphicsContext gc = canvas.getGraphicsContext2D();*/
        gc.setFill(c);
    }


}
