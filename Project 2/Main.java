//Chengliang Tan Exercise 2 Main.java

package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

        MyLine line1 = new MyLine();
        MyLine line2 = new MyLine();
        MyCircle cir1 = new MyCircle();
        MyCircle cir2 = new MyCircle();
        MyCircle cir3 = new MyCircle();
        MyCircle cir4 = new MyCircle();
        MyPolygon pol1 = new MyPolygon();
        MyPolygon pol2 = new MyPolygon();
        MyPolygon pol3 = new MyPolygon();

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception{
            primaryStage.setTitle("MyShape");
            Group root = new Group();
            Canvas canvas = new Canvas(800,400);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            Scene s = new Scene(root, 1066.6662, 600, Color.WHITE);
            pol1 = new MyPolygon(canvas.getWidth()/2.0, canvas.getHeight()/2.0,canvas.getHeight()/2.1,5, MyColor.FLORALWHITE, MyColor.PINK, true);
            pol1.draw(gc);
            pol2 = new MyPolygon(canvas.getWidth()/2.0, canvas.getHeight()/2.0,pol1.getRadius()/1.24,5, MyColor.THISTLE,MyColor.CHARTRUSE,true);
            pol2.draw(gc);
            pol3 = new MyPolygon(canvas.getWidth()/2.0, canvas.getHeight()/2.0,pol2.getRadius()/1.24,5, MyColor.BROWN,MyColor.PALETURQUOISE,true);
            pol3.draw(gc);
            cir4 = new MyCircle(canvas.getWidth()/2.0,canvas.getHeight()/2.0,pol3.getRadius()/1.24, MyColor.WHITE,true);
            cir4.draw(gc);
            line1 = new MyLine(0,0, canvas.getWidth(), canvas.getHeight(), MyColor.BLACK);
            line1.draw(gc);
            line2 = new MyLine(canvas.getWidth(),0,0, canvas.getHeight(), MyColor.BLACK);
            line2.draw(gc);
            root.getChildren().add(canvas);
            primaryStage.setScene(s);
            primaryStage.show();
        }



}

