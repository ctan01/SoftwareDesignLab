package sample;

import javafx.scene.paint.Color;
//import javafx.scene.paint.Color;

enum MyColor {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    LEMONCHIFFON(255,250,205),
    GREENYELLOW(173, 155, 47),
    PERU(205, 133,63),
    PALETURQUOISE(175, 238, 238),
    GOLD(255, 215, 0),
    PLUM(221, 160, 221),
    YELLOW(255, 255, 0),
    WHITE(255, 255, 255),
    BLACK(0, 0, 0);

    public int red;
    public int green;
    public int blue;
    public MyColor color;
    public static Color c;
    public String colorRGB;

    MyColor(){
        this.red = 0;
        this.green = 0;
        this.blue = 0;
        this.colorRGB =  getRed() + ", " + getGreen() + ", " + getBlue() + "\n";
    }

    MyColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.colorRGB =  getRed() + ", " + getGreen() + ", " + getBlue() + "\n";
    }

    public MyColor mixColor(MyColor color1, MyColor color2){
        MyColor newColor = null;
        newColor.red = (color1.getRed() + color2.getRed())/2;
        newColor.green = (color1.getGreen() + color2.getGreen())/2;
        newColor.blue = (color1.getBlue() + color2.getBlue())/2;
        return newColor;
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

    public String getColorRGB(){
        return colorRGB;
    }

}


/*public enum MyColor {
    RED,
    BLUE,
    GREEN,
    WHITE,
    BLACK;

    private int red;
    private int green;
    private int blue;
    private String colorRGB;
    private static Color color;

    MyColor(){}

    public MyColor(int inRed, int inGreen, int inBlue){
        setRed(inRed);
        setGreen(inGreen);
        setBlue(inBlue);
        this.colorRGB = getRed() + ", " + getGreen() + ", " + getBlue() + "\n";
    }

    public static Color getColor(){
        return color;
    }
    public String getColorRGB(){
        return colorRGB;
    }

    public void setRed(int inRed){
        this.red = inRed;
    }

    public void setBlue(int inBlue){
        this.blue = inBlue;
    }

    public void setGreen(int inGreen){
        this.green = inGreen;
    }

    public int getRed(){
        return red;
    }

    public int getGreen(){
        return green;
    }

    public int getBlue() {
        return blue;
    }



}*/

/*public class MyColor{

    Color c;

    public MyColor(){}
}*/


 /*public Color mixColor(){

    }*/


    /*RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    LEMONCHIFFON(255,250,205),
    GREENYELLOW(173, 155, 47),
    BROWN(165, 42 ,42),
    AQUA(0, 255, 255),
    GOLD(255, 215, 0),
    PLUM(221, 160, 221),
    YELLOW(255, 255, 0),
    WHITE(255, 255, 255),
    BLACK(0, 0, 0);


    private int red;
    private int green;
    private int blue;
    private String color;

    MyColor(int inRed, int inGreen, int inBlue){
        setRed(inRed);
        setGreen(inGreen);
        setBlue(inBlue);
        this.color = getRed() + ", " + getGreen() + ", " + getBlue() + "\n";
    }


    public void setRed(int inRed){
        this.red = inRed;
    }

    public void setBlue(int inBlue){
        this.blue = inBlue;
    }

    public void setGreen(int inGreen){
        this.green = inGreen;
    }

    public int getRed(){
        return red;
    }

    public int getGreen(){
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public String getColor() {
        return color;
    }*/

    /*public MyColor mixColor(MyColor color1, MyColor color2){
        MyColor newColor = new MyColor();
        newColor.red = color1.red + color2.red;
        newColor.green = color1.green + color2.green;
        newColor.blue = color1.blue + color2.blue;
        return newColor;
    }*/