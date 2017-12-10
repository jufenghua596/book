/*
 * Copyright 2011 Cheng Fu
 */
package javafx.animation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author chengfu
 */
public class JavafxAnimation extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Animation");

        Group root = new Group();
        final Rectangle rect = new Rectangle(200, 100);
        final double distanceX = 400;
        final double distanceY = 300;
        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(3000));
            }
            protected void interpolate(double frac) {
                rect.setX(distanceX * frac);
                rect.setY(distanceY * frac);
            }
        };
        animation.setCycleCount(Animation.INDEFINITE);
        animation.setAutoReverse(true);
        animation.play();
        root.getChildren().add(rect);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
