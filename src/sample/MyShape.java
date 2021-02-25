package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class MyShape {
    public double x;
    public double y;
   // public Color c = Color.rgb(color.getRed(),  );
    public MyColor color;

    //constructors_______________________________________________________________
    public MyShape(){
        this.setX(0);
        this.setY(0);
        this.setColor(MyColor.BLACK);
    }

    public MyShape(double inX, double inY, MyColor inColor){
        this.setX(inX);
        this.setY(inY);
        this.setColor(inColor);
    }


    //get functions__________________________________________________________________
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public MyColor getColor() {
        return color;
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

    void draw(GraphicsContext gc, Color inColor) {
        /*Canvas canvas = new Canvas(400,600);
        GraphicsContext gc = canvas.getGraphicsContext2D();*/
        gc.setFill(inColor);
    }


}
