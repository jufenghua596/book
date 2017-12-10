/*
 * Copyright 2011 Cheng Fu
 */
package javafx.animation.timeline;

import javafx.scene.paint.Color;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
public class JavafxAnimationTimeline extends Application {

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
        final Rectangle rect = new Rectangle(200, 100, Color.WHITE);
        final Animation animation = new Timeline(
            new KeyFrame(Duration.seconds(2), new KeyValue(rect.xProperty(), 100), new KeyValue(rect.fillProperty(), Color.RED)),
            new KeyFrame(Duration.seconds(4), new KeyValue(rect.xProperty(), 200), new KeyValue(rect.fillProperty(), Color.WHITE))
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        root.getChildren().add(rect);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
