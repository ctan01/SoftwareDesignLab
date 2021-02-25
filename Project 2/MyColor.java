//Chengliang Tan Exercise 2 MyColor.java

package sample;

import javafx.scene.paint.Color;
//import javafx.scene.paint.Color;

enum MyColor {
    NEW(0,0,0,1),
    RED(255, 0, 0,1),
    GREEN(0, 255, 0,1),
    BLUE(0, 0, 255,1),
    LEMONCHIFFON(255,250,205,1),
    GREENYELLOW(173, 155, 47,1),
    PERU(205, 133,63,1),
    PALETURQUOISE(175, 238, 238,1),
    GOLD(255, 215, 0,1),
    PLUM(221, 160, 221,1),
    PINK(255,192,203,1),
    FLORALWHITE(255,250,240,1),
    CHARTRUSE(127,255,0,1),
    THISTLE(216,191,216,1),
    BROWN(165,42,42,1),
    WHITE(255, 255, 255,1),
    BLACK(0, 0, 0,1),
    CBLACK(0,0,0,0.5);

    private int red;
    private int green;
    private int blue;
    private double transparency;
    private MyColor color;
    private static Color c;
    private String colorRGB;

    MyColor(){
        this.red = 0;
        this.green = 0;
        this.blue = 0;
        this.transparency = 0;
        this.colorRGB =  getRed() + ", " + getGreen() + ", " + getBlue() + "\n";
    }

    MyColor(int inRed, int inGreen, int inBlue, double inTrans) {
        this.red = inRed;
        this.green = inGreen;
        this.blue = inBlue;
        this.transparency = inTrans;
        this.colorRGB =  getRed() + ", " + getGreen() + ", " + getBlue() + "\n";
    }

    public void mixColor(MyColor inColor){
        this.red = (this.getRed() + inColor.getRed())/2;
        this.green = (this.getGreen() + inColor.getGreen())/2;
        this.blue = (this.getBlue() + inColor.getBlue())/2;
        this.transparency = (this.getTrans() + inColor.getTrans())/2;
    }

    public static Color getColor(){
        return c;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public double getTrans(){
        return transparency;
    }

    public String getColorRGB(){
        return colorRGB;
    }

}

