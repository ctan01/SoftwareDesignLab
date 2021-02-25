package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;

class MyArc{
    double x;
    double y;
    double w;
    double h;
    double startAngle;
    double arcExtent;
    ArcType closure = ArcType.ROUND;
    Paint c;


    MyArc(){
        this.setX(0);
        this.setY(0);
        this.setW(0);
        this.setH(0);
        this.setStartAngle(0);
        this.setArcExtent(0);
        this.setColor(Color.BLACK);
    }

    //input array of startangle, array of arccextent
    MyArc(double inX, double inY, double inW, double inH, double inStartAngle, double inArcExtent, Paint inColor){
        this.setX(inX);
        this.setY(inY);
        this.setW(inW);
        this.setH(inH);
        this.setStartAngle(inStartAngle);
        this.setArcExtent(inArcExtent);
        this.setColor(inColor);
    }

    void setX(double inX){
        this.x = inX;
    }

    void setY(double inY){
        this.y = inY;
    }

    void setW(double inW){
        this.w = inW;
    }

    void setH(double inH){
        this.h = inH;
    }

    void setStartAngle(double inStartAngle){
        this.startAngle = inStartAngle;
    }

    void setArcExtent(double inArcExtent){
        this.arcExtent = inArcExtent;
    }

    void setColor(Paint inColor){
        this.c = inColor;
    }

    double getX(){
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

    double getStartAngle(){
        return this.startAngle;
    }

    double getArcExtent(){
        return this.arcExtent;
    }

    ArcType getClosure(){
        return this.closure;
    }

    Paint getColor(){
        return this.c;
    }

    public double getUpperLeftX(){
        return getX() - (getW()/2);
    }

    public double getUpperLeftY(){
        return getY() - (getH()/2);
    }

    //draw using for loop same x,y,w,h but different start angle and arc extent from the array.
    public void draw(GraphicsContext gc){
            gc.setFill(getColor());
            gc.fillArc(getUpperLeftX(), getUpperLeftY(), getW(), getH(), getStartAngle(), getArcExtent(), getClosure());
    }
}


              /*pieChart[] pieCharts = new pieChart[getChoice(choiceBox)];
                pieCharts[0] = new pieChart(canvas.getWidth()/2.0, canvas.getHeight()/2.0, canvas.getHeight()/2.1, canvas.getHeight()/2.1, 0, arcExtent[0], randomColor());
                for(int i = 1; i < getN(); i++){
                    pieCharts[i] = new pieChart(canvas.getWidth()/2.0, canvas.getHeight()/2.0, canvas.getHeight()/2.1, canvas.getHeight()/2.1, pieCharts[i-1].getStartAngle()+pieCharts[i-1].getArcExtent(), arcExtent[i], randomColor());
                }
                for(int j = 0; j < getN(); j++){
                    pieCharts[j].draw(gc);
                }*/

