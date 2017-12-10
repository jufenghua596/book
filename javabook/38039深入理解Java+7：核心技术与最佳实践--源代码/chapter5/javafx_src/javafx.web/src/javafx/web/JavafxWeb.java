/*
 * Copyright 2011 Cheng Fu
 */
package javafx.web;

import java.nio.file.Paths;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author chengfu
 */
public class JavafxWeb extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Web Test");
        WebView view = new WebView();
        primaryStage.setScene(new Scene(view, 800, 600));
        primaryStage.show();
        final WebEngine engine = view.getEngine();
        String url = "http://localhost/test.html";
        engine.load(url);
        final Worker worker = engine.getLoadWorker();
        worker.workDoneProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() == 100) {
                    worker.workDoneProperty().removeListener(this);
                    engine.locationProperty().addListener(new ChangeListener<String>() {
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            System.out.println(newValue); //检查地址是否正确
                        }
                    });
                    Document doc = engine.getDocument();
                    Element nameElem = doc.getElementById("name");
                    nameElem.setAttribute("value", "alex");
                    Element passwordElem = doc.getElementById("password");
                    passwordElem.setAttribute("value", "password");
                    String script = "document.getElementById('form').submit();";
                    engine.executeScript(script);
                }
            }
        });
    }
}
