package main;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    Text times = new Text();

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(getGrid(),555,240);
        scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Le Digital Clock");
        primaryStage.show();
    }

    private GridPane getGrid() {
        setTexts();
        GridPane grid = new GridPane();
        grid.add(times, 0, 0);
        return grid;
    }

    private void setTexts() {
        bindToTime();
        times.setFont(Font.font("Segoe UI",150));
        times.setFill(Color.GREENYELLOW);
        times.setTextAlignment(TextAlignment.CENTER);
    }

    private void bindToTime() {
        DateTimeFormatter SHORT_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setText(LocalTime.now().format(SHORT_TIME_FORMATTER));
            }

            private void setText(String format) {
                times.setText(format);
            }
        }),
                new KeyFrame(Duration.seconds(1)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
