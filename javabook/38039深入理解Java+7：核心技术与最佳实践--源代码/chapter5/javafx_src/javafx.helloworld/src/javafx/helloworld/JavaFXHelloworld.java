/*
 * Copyright 2011 Cheng Fu
 */
package javafx.helloworld;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author chengfu
 */
public class JavaFXHelloworld extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public void init() {
        System.out.println(Thread.currentThread());
    }

    public void start(Stage primaryStage) {
        System.out.println("APP:" + Thread.currentThread());
        primaryStage.setTitle("JavaFX Sample");
        Button button = new Button();
        button.setText("Button");
        final Label label = new Label();
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                label.setText("Hello World!");
            }
        });
        BorderPane pane = new BorderPane();
        pane.setTop(button);
        pane.setBottom(label);
        Group root = new Group(pane);
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }
}
