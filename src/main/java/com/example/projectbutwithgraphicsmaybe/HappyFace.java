package com.example.projectbutwithgraphicsmaybe;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

import java.util.ArrayList;


public class HappyFace extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage)
    {
        ArrayList<Dot> dots = new ArrayList<>();
        Point origin = new Point(500,500);

        for (int i = 100; i <= 900; i += 10) {
            for (int j = 100; j <= 900; j += 10) {
            dots.add(new Dot(i, j, origin));
            }
        }

        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(1000, 1000);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        primaryStage.setScene(scene);


        for (int i = 0; i < 1000; i++) {
            for (Dot dot : dots) {
                gc.fillOval(dot.getX(), dot.getY(), 0.25, 0.25);
                dot.rotate(i % 30);
                dot.extend(i % 10 - 7);
            }
            primaryStage.show();


        }
    }
}
