//Chengliang Tan Exercise 2 MyLine.java

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
    public Color c;

    //constructors______________________________________________________________
    public MyLine(){
        this.setX1(0);
        this.setY1(0);
        this.setX2(0);
        this.setY2(0);
        this.setLength(0);
        this.setAngle(0);
        this.setColor(MyColor.BLACK);
        this.c = Color.BLACK;
        this.length = 0;
        this.angle = 0;
    }


    public MyLine(double inX1, double inY1, double inX2, double inY2, MyColor inColor){
        this.setX1(inX1);
        this.setY1(inY1);
        this.setX2(inX2);
        this.setY2(inY2);
        this.setLength(getLength());
        this.setAngle(getAngle());
        this.setColor(inColor);
        this.c = Color.rgb(color.getRed(), color.getGreen(), color.getBlue(), color.getTrans());
        this.length = getLength();
        this.angle = getAngle();
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
        length = Math.sqrt(Math.pow(getX2()-getX1(),2) + Math.pow(getY2()-getY1(),2));
        return length;
    }

    public double getAngle(){
        angle = Math.toDegrees(Math.atan((getY2()-getY1())/(getX2()-getX1())));
        return angle;
    }

    public Color getColor(){
        return c;
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
        return "Length: " + getLength() + "\t" + "Angel: " + getAngle() + "\n";
    }

    @Override
    public void draw(GraphicsContext gc){
        /*Canvas canvas = new Canvas(400,600);
        GraphicsContext gc = canvas.getGraphicsContext2D();*/
        gc.setStroke(c);
        gc.strokeLine(getX1(), getY1(), getX2(), getY2());
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
        return new MyRectangle(this.getX1(), this.getY1(), getLength() * Math.cos(getAngle()), getLength() * Math.sin(getAngle()), MyColor.RED, true);
    }

}
