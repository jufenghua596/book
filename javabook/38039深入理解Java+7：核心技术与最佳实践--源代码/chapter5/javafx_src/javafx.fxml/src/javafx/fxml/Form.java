/*
 * Copyright 2011 Cheng Fu
 */
package javafx.fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author chengfu
 */
public class Form implements Initializable {
    
    @FXML
    private Label message;
    
    @FXML
    private TextField name;
    
    @FXML
    private ListView gender;
    
    @FXML
    private void say(ActionEvent event) {
        message.setText("Hello, " + gender.getSelectionModel().getSelectedItem() + name.getText());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
