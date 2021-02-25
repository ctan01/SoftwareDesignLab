package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Main extends Application {

    MyRectangle rect1 = new MyRectangle();
    MyRectangle rect2 = new MyRectangle();
    MyRectangle rect3 = new MyRectangle();
    MyOval oval1 = new MyOval();
    MyOval oval2 = new MyOval();
    MyOval oval3 = new MyOval();
    MyLine line1 = new MyLine();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("MyShape");
        Group root = new Group();
        Canvas canvas = new Canvas(1600,900);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Scene s = new Scene(root, 1600, 900, Color.WHITE);
        rect1 = new MyRectangle(canvas.getWidth()/2.0,canvas.getHeight()/2.0,canvas.getWidth()/2,canvas.getHeight()/2, MyColor.LEMONCHIFFON,true);
        rect1.draw(gc,Color.LEMONCHIFFON);
        oval1 = new MyOval(canvas.getWidth()/2.0,canvas.getHeight()/2.0,canvas.getWidth()/2,canvas.getHeight()/2, MyColor.GREENYELLOW, true);
        oval1.draw(gc,Color.GREENYELLOW);
        rect2 = new MyRectangle(canvas.getWidth()/2.0,canvas.getHeight()/2.0,canvas.getWidth()/2.851,canvas.getHeight()/2.851, MyColor.PERU,true);
        rect2.draw(gc,Color.PERU);
        oval2 = new MyOval(canvas.getWidth()/2.0,canvas.getHeight()/2.0,canvas.getWidth()/2.851,canvas.getHeight()/2.851, MyColor.PALETURQUOISE, true);
        oval2.draw(gc,Color.PALETURQUOISE);
        rect3 = new MyRectangle(canvas.getWidth()/2.0,canvas.getHeight()/2.0,canvas.getWidth()/4.06,canvas.getHeight()/4.06, MyColor.GOLD,true);
        rect3.draw(gc,Color.GOLD);
        oval3 = new MyOval(canvas.getWidth()/2.0,canvas.getHeight()/2.0,canvas.getWidth()/4.06,canvas.getHeight()/4.06, MyColor.PLUM, true);
        oval3.draw(gc,Color.PLUM);
        line1 = new MyLine(0,0,canvas.getWidth(),canvas.getHeight(), MyColor.BLACK);
        line1.draw(gc,Color.BLACK);
        root.getChildren().add(canvas);
        primaryStage.setScene(s);
        primaryStage.show();
    }



}

        /*Group root = new Group();
        primaryStage.setTitle("MyShape");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();

        //Scene s = new Scene(root, 300,300, Color.BLACK);
        final Canvas canvas = new Canvas(400,400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(75,75,100,100);
        root.getChildren().add(canvas);*/

        /*shape3.setX1(25);
        shape3.setY1(100);
        shape3.setX2(30);
        shape3.setY2(200);*/