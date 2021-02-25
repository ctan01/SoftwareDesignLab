package sample;

public interface MyPositionInterface{
    double[] getPoint();

    void moveTo(double inX, double inY);

    double distanceTo(double inX, double inY);
}
