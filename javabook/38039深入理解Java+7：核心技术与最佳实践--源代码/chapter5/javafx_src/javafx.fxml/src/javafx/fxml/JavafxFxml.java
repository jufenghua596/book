/*
 * Copyright 2011 Cheng Fu
 */
package javafx.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

/**
 *
 * @author chengfu
 */
public class JavafxFxml extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Form.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
