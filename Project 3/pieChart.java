package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;

import java.util.Random;

class pieChart {
    private static int n;
    public static double x;
    private static double y;
    private static double w;
    private static double h;
    private static float[] startAngle = new float[26]; //pieCharts[i-1].getStartAngle()+pieCharts[i-1].getArcExtent()
    private static float[] arcExtent = new float[26];
    private static ArcType closure = ArcType.ROUND;


    pieChart(){
        this.setN(0);
        this.setX(0);
        this.setY(0);
        this.setW(0);
        this.setH(0);
        this.setArcExtent(arcExtent);
    }

    pieChart(int inN, double inX, double inY, double inW, double inH, float[] inArcExtent){
        this.setN(inN);
        this.setX(inX);
        this.setY(inY);
        this.setW(inW);
        this.setH(inH);
        this.setArcExtent(inArcExtent);
        setStartAngle();
    }

    private void setN(int inN){
        this.n = inN;
    }

    private void setX(double inX){
        this.x = inX;
    }

    private void setY(double inY){
        this.y = inY;
    }

    private void setW(double inW){
        this.w = inW;
    }

    private void setH(double inH){
        this.h = inH;
    }

    private void setStartAngle(){
        startAngle[0] = 0;
        for(int i = 1; i < getN(); i++) startAngle[i] = startAngle[i-1] + arcExtent[i-1];
    }

    private void setArcExtent(float[] inArcExtent){
        for(int i = 0; i < getN(); i++) arcExtent[i] = inArcExtent[i];
    }

    private int getN(){
        return this.n;
    }

    public double getX(){
        return this.x;
    }

    double getY(){
        return this.y;
    }

    double getW(){
        return this.w;
    }

    double getH(){
        return this.h;
    }

    double getStartAngle(int index){
        return this.startAngle[index];
    }

    double getArcExtent(int index){
        return this.arcExtent[index];
    }

    private ArcType getClosure(){
        return this.closure;
    }

    private double getUpperLeftX(){
        return getX() - (getW()/2);
    }

    private double getUpperLeftY(){
        return getY() - (getH()/2);
    }

    public double getSum(){
        double sum = 0;
        for(int i = 0; i < getN(); i++){
            sum = sum + arcExtent[i];
        }
        return sum;
    }

    private Paint randomColor() {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return Color.rgb(r, g, b);
    }

    void draw(GraphicsContext gc){
        gc.setFill(randomColor());
        gc.fillArc(getUpperLeftX(), getUpperLeftY(), getW(), getH(), getStartAngle(0), getArcExtent(0), getClosure());
        gc.fillText("e", getX(), getY());
        for(int i = 1; i < getN(); i++){
            gc.setFill(randomColor());
            gc.fillArc(getUpperLeftX(), getUpperLeftY(), getW(), getH(), getStartAngle(i), getArcExtent(i), getClosure());
        }
        gc.setFill(randomColor());
        gc.fillArc(getUpperLeftX(), getUpperLeftY(), getW(), getH(), getSum(), 360 - getSum(), getClosure());
        System.out.println("all other: " + ((360 - getSum())/360)*100 + "%");
    }

}
