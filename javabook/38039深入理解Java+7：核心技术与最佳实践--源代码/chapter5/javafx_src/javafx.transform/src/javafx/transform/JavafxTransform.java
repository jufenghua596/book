/*
 * Copyright 2011 Cheng Fu
 */
package javafx.transform;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 *
 * @author chengfu
 */
public class JavafxTransform extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Group root = new Group();
        Rectangle rect = new Rectangle(200, 100);
        rect.setStyle("-fx-fill: #FF0000");
        rect.getTransforms().add(new Translate(100, 50));
        rect.getTransforms().add(new Rotate(30, 100, 50));
        rect.getTransforms().add(new Scale(2, 1.5));
        rect.getTransforms().add(new Shear(0.5, 0));
        root.getChildren().add(rect);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
