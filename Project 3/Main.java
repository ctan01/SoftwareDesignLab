package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application implements EventHandler<ActionEvent> {

    private Stage window;
    private Scene scene1, scene2;

    private ChoiceBox<Integer> choiceBox;

    public void call() throws IOException {
        HistogramAlphaBet.main(null);
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;//rename to window

        primaryStage.setTitle("Pie Chart");//title of the window

        //scene 1_____________________________________
        Label label1 = new Label("Please select n");

        choiceBox = new ChoiceBox<>();// drop down list
        choiceBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26);
        choiceBox.setValue(1);//set default value

        Button button1 = new Button();
        button1.setText("Confirm");
        button1.setOnAction(e -> window.setScene(scene2));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, choiceBox, button1);
        scene1 = new Scene(layout1, 600, 600);

        //scene 2_____________________________________________________________________________

        Canvas canvas = new Canvas(600,600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //go to scene 1
        Button button3 = new Button();
        button3.setText("Back");
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                window.setScene(scene1);
            }
        });

        Button button2 = new Button();
        button2.setText("Generate pie chart");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    call();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                float[] arcExtent = new float[26];

                for(int i = 0; i < 26; i++){
                    arcExtent[i] = (HistogramAlphaBet.prob[i]/100)*360;
                }

                for(int i = 0; i < getChoice(choiceBox); i++){
                    System.out.println(HistogramAlphaBet.alphabets[i] + ": " + HistogramAlphaBet.prob[i] + "%");
                }

                pieChart pie1 = new pieChart(getChoice(choiceBox), canvas.getWidth()/2.0, canvas.getHeight()/2.0, canvas.getHeight()/2.1, canvas.getHeight()/2.1, arcExtent);
                pie1.draw(gc);

                //legend
                for(int i = 0; i < getChoice(choiceBox); i++)
                {
                    gc.setFill(Color.BLACK);
                    gc.fillText(HistogramAlphaBet.alphabets[i] + ": " + HistogramAlphaBet.prob[i] + "%" , pie1.getX() + pie1.getW() * Math.cos(Math.toRadians(((pie1.getArcExtent(i) / 2) + pie1.getStartAngle(i))))/2,pie1.getY() - pie1.getH() * Math.sin(Math.toRadians(((pie1.getArcExtent(i) / 2) +pie1.getStartAngle(i)))) / 2);
                }
                gc.fillText("all others: " + ((360 - pie1.getSum())/360)*100 + "%" , (pie1.getX() - (canvas.getWidth() / 3)) + pie1.getW() * Math.cos(Math.toRadians((((360 - pie1.getSum()) / 2) + pie1.getSum())))/2,pie1.getY() - pie1.getH() * Math.sin(Math.toRadians((((360 - pie1.getSum()) / 2) + pie1.getSum())))/2);
            }

        });

        VBox layout2 = new VBox();
        scene2 = new Scene(layout2, 600, 600);
        layout2.getChildren().addAll(button3, button2, canvas);


        window.setScene(scene1);
        window.show();
    }//end start

    @Override
    public void handle(ActionEvent actionEvent) {

    }

    private int getChoice(ChoiceBox<Integer> choiceBox){
        return choiceBox.getValue();
    }

}
