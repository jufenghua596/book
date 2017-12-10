/*
 * Copyright 2011 Cheng Fu
 */
package javafx.css;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author chengfu
 */
public class JavafxCss extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CSS");
        
        Group root = new Group();
        Rectangle rect = new Rectangle(100, 50);
        rect.setId("rect");
        root.getChildren().add(rect);
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add("main.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
