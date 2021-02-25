package sample;



import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyLine extends MyShape {
    public double x1;
    public double y1;
    public double x2;
    public double y2;
    public double length;
    public double angle;
    public MyColor color;

    //constructors______________________________________________________________
    public MyLine(){
        this.setX1(0);
        this.setY1(0);
        this.setX2(0);
        this.setY2(0);
        this.setLength(0);
        this.setAngle(0);
        this.setColor(MyColor.BLACK);
    }


    public MyLine(double inX1, double inY1, double inX2, double inY2, MyColor inColor){
        this.setX1(inX1);
        this.setY1(inY1);
        this.setX2(inX2);
        this.setY2(inY2);
        this.setLength(Math.sqrt(Math.pow(inX2-inX1,2) + Math.pow(inY2-inY1,2)));
        this.setAngle(Math.toDegrees(Math.atan((inY2-inY1)/(inX2-inX1))));
        this.setColor(inColor);
    }

    //get functions____________________________________________________________

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getLength() {
        return length;
    }

    public double getAngle(){
        return angle;
    }

    public MyColor getColor(){
        return color;
    }


    //set functions____________________________________________________________
    public void setX1(double inX1) {
        this.x1 =inX1;
    }

    public void setY1(double inY1) {
        this.y1 = inY1;
    }

    public void setX2(double inX2) {
        this.x2 = inX2;
    }

    public void setY2(double inY2) {
        this.y2 = inY2;
    }

    public void setLength(double inLength) {
        this.length = inLength;
    }

    public void setAngle(double inAngle){
        this.angle = inAngle;
    }

    public void setColor(MyColor inColor){
        this.color = inColor;
    }

    //other methods__________________________________________________________
    @Override
    public String toString() {
        return "Length: " + getLength() + "\n" + "Angel: " + getAngle() + "\n";
        //return "(" + x1 + ", "+ y1 + ")" + ", " + "(" + x2 + ", "+ y2 + ")" + ", " + color + ;
    }

    @Override
    void draw(GraphicsContext gc, Color inColor){
        /*Canvas canvas = new Canvas(400,600);
        GraphicsContext gc = canvas.getGraphicsContext2D();*/
        gc.setStroke(inColor);
        gc.strokeLine(getX1(), getY1(), getX2(), getY2());
    }
    /*@Override
    public void draw(Graphics g){
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }*/


}
