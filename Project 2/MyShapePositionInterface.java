package sample;

interface MyShapePositionInterface extends MyPositionInterface {
    @Override
    double[] getPoint();

    @Override
    void moveTo(double inX, double inY);

    @Override
    double distanceTo(double inX, double inY);

    MyRectangle getMyBoundingBox();

    static boolean doOverlap(MyRectangle inShape1, MyRectangle inShape2){
        if(inShape1.getX() > (inShape1.getX() + inShape2.getWidth()) || inShape2.getX() > (inShape1.getX() + inShape1.getWidth()))
            return false;
        else if(inShape1.getY() > (inShape1.getY() + inShape2.getHeight()) || inShape2.getY() > (inShape1.getY() + inShape1.getHeight()))
            return false;
        else return true;
    }

    static boolean doOverlap(MyRectangle inShape1, MyOval inShape2){
        if(inShape1.getX() > (inShape1.getX() + inShape2.getWidth()) || inShape2.getX() > (inShape1.getX() + inShape1.getWidth()))
            return false;
        else if(inShape1.getY() > (inShape1.getY() + inShape2.getHeight()) || inShape2.getY() > (inShape1.getY() + inShape1.getHeight()))
            return false;
        else return true;
    }

    static boolean doOverlap(MyRectangle inShape1, MyCircle inShape2){
        if(inShape1.getX() > (inShape1.getX() + inShape2.getRadius()) || inShape2.getX() > (inShape1.getX() + inShape1.getWidth()))
            return false;
        else if(inShape1.getY() > (inShape1.getY() + inShape2.getRadius()) || inShape2.getY() > (inShape1.getY() + inShape1.getHeight()))
            return false;
        else return true;
    }

    static boolean doOverlap(MyRectangle inShape1, MyPolygon inShape2){
        if(inShape1.getX() > (inShape1.getX() + inShape2.getRadius()) || inShape2.getX() > (inShape1.getX() + inShape1.getWidth()))
            return false;
        else if(inShape1.getY() > (inShape1.getY() + inShape2.getRadius()) || inShape2.getY() > (inShape1.getY() + inShape1.getHeight()))
            return false;
        else return true;
    }

    static boolean doOverlap(MyOval inShape1, MyOval inShape2){
        if(inShape1.getX() > (inShape1.getX() + inShape2.getWidth()) || inShape2.getX() > (inShape1.getX() + inShape1.getWidth()))
            return false;
        else if(inShape1.getY() > (inShape1.getY() + inShape2.getHeight()) || inShape2.getY() > (inShape1.getY() + inShape1.getHeight()))
            return false;
        else return true;
    }

    static boolean doOverlap(MyOval inShape1, MyCircle inShape2){
        if(inShape1.getX() > (inShape1.getX() + inShape2.getRadius()) || inShape2.getX() > (inShape1.getX() + inShape1.getWidth()))
            return false;
        else if(inShape1.getY() > (inShape1.getY() + inShape2.getRadius()) || inShape2.getY() > (inShape1.getY() + inShape1.getHeight()))
            return false;
        else return false;
    }

    static boolean doOverlap(MyOval inShape1, MyPolygon inShape2){
        if(inShape1.getX() > (inShape1.getX() + inShape2.getRadius()) || inShape2.getX() > (inShape1.getX() + inShape1.getWidth()))
            return false;
        else if(inShape1.getY() > (inShape1.getY() + inShape2.getRadius()) || inShape2.getY() > (inShape1.getY() + inShape1.getHeight()))
            return false;
        else return true;
    }

    static boolean doOverlap(MyCircle inShape1, MyCircle inShape2){
        if(inShape1.getX() > (inShape1.getX() + inShape2.getRadius()) || inShape2.getX() > (inShape1.getX() + inShape1.getRadius()))
            return false;
        else if(inShape1.getY() > (inShape1.getY() + inShape2.getRadius()) || inShape2.getY() > (inShape1.getY() + inShape1.getRadius()))
            return false;
        else return false;
    }

    static boolean doOverlap(MyCircle inShape1, MyPolygon inShape2){
        if(inShape1.getX() > (inShape1.getX() + inShape2.getRadius()) || inShape2.getX() > (inShape1.getX() + inShape1.getRadius()))
            return false;
        else if(inShape1.getY() > (inShape1.getY() + inShape2.getRadius()) || inShape2.getY() > (inShape1.getY() + inShape1.getRadius()))
            return false;
        else return true;
    }

    static boolean doOverlap(MyPolygon inShape1, MyPolygon inShape2){
        if(inShape1.getX() > (inShape1.getX() + inShape2.getRadius()) || inShape2.getX() > (inShape1.getX() + inShape1.getRadius()))
            return false;
        else if(inShape1.getY() > (inShape1.getY() + inShape2.getRadius()) || inShape2.getY() > (inShape1.getY() + inShape1.getRadius()))
            return false;
        else return true;
    }
}