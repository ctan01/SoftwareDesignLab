//Chengliang Tan Exercise 2 MyPolygon.java

package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyPolygon extends MyShape {
    private int N; //number of polygon's equal side length
    private double radius; //radius of circle that inscribes the polygon
    private boolean filled;
    private double perimeter;
    private double area;
    private double sideLength;
    private double interAngle;
    double[] xPoints;
    double[] yPoints;
    public MyColor cirColor;
    public Color c1;


    //constructors____________________________________________________________
    public MyPolygon(){
        super();
        this.setN(0);
        this.setRadius(0);
        this.filled = true;
        this.perimeter = 0;
        this.area = 0;
        this.interAngle = 0;
        this.sideLength = 0;
    }

    public MyPolygon(double inX, double inY, double inRadius, int inN, MyColor inColor, MyColor inCirColor, boolean isFilled){
        super(inX, inY, inColor);
        this.setN(inN);
        this.setRadius(inRadius);
        this.setFilled(isFilled);
        this.perimeter = getPerimeter();
        this.area = getArea();
        this.sideLength = getSideLength();
        this.interAngle = getInteriorAngle();
        this.cirColor = inCirColor;
        this.c1 = Color.rgb(cirColor.getRed(), cirColor.getGreen(), cirColor.getBlue(), cirColor.getTrans());
    }

    //get functions____________________________________________________________
    public int getN(){
        return N;
    }

    public boolean isFilled(){
        return filled;
    }

    public double getPerimeter(){
        perimeter = getSideLength()*getN();
        return perimeter;
    }

    public double getArea(){
        area = (1/2)*getN()*getRadius()*getRadius();
        return area;
    }

    public double getInteriorAngle(){
        interAngle = ((getN()-2)/getN())*180;
        return interAngle;
    }

    public double getSideLength(){
        sideLength = 2*getRadius()*Math.sin(Math.PI/getN());
        return sideLength;
    }

    public double[] getXPoints(){
        this.xPoints = new double[getN()];
        for(int i = 0; i < N; i++){
            xPoints[i] = getX() + getRadius()*Math.sin((2*Math.PI*i)/getN());
        }
        return xPoints;
    }

    public double[] getYPoints(){
        this.yPoints = new double[getN()];
        for(int i = 0; i < N; i++){
            yPoints[i] = getY() + -1*(getRadius()*Math.cos((2*Math.PI*i)/getN()));
        }
        return yPoints;
    }

    public Color getColor() {
        return c;
    }

    public double getRadius(){
        return radius;
    }

    public double getUpperLeftX(){
        return getX() - getRadius();
    }

    public double getUpperLeftY(){
        return getY() - getRadius();
    }

    //set functions____________________________________________________________
    public void setN(int inN){
        this.N = inN;
    }

    public void setFilled(boolean isFilled){
        this.filled = isFilled;
    }

    public void setRadius(double inRadius){
        this.radius = inRadius;
    }
    //other methods_____________________________________________________________
    @Override
    public String toString(){
        return "Side Length: " + getSideLength() + "\t" + "Interior Angle: " + getInteriorAngle() + "\t" + "Perimeter: "+ getPerimeter() + "\t" +
                "Area: " + getArea() + "\n";
    }

    @Override
    public void draw(GraphicsContext gc){
        if(isFilled()){
            gc.setFill(c1);
            gc.fillOval(getUpperLeftX(), getUpperLeftY(), getRadius()*2, getRadius()*2);
            gc.setFill(c);
            gc.fillPolygon(getXPoints(), getYPoints(), getN());
        }
        else {
            gc.strokePolygon(getXPoints(), getYPoints(), getN());
            gc.strokeOval(getUpperLeftX(), getUpperLeftY(), getRadius(), getRadius());
        }
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
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        for(int i = 0; i < this.getN(); i++) {
            if(xPoints[i] < minX)
                minX = xPoints[i];
            if(xPoints[i] > maxX)
                maxX = xPoints[i];
            if(xPoints[i] < minY)
                minY = xPoints[i];
            if(xPoints[i] > maxY)
                maxY = xPoints[i];
        }

        return new MyRectangle(minX, minY, maxX - minX, maxY - minY, MyColor.CBLACK, true);
    }

}
