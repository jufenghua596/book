/*
 * Copyright 2011 Cheng Fu
 */
package javafx.player;

import java.awt.BorderLayout;
import javafx.application.Platform;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JLabel;

/**
 *
 * @author chengfu
 */
public class JavafxPlayer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initAndShowUI();
            }
        });
    }

    private static void initAndShowUI() {
        JFrame frame = new JFrame("Music Player");
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel, BorderLayout.NORTH);
        final JLabel label = new JLabel();
        frame.add(label, BorderLayout.CENTER);
        frame.setSize(400, 200);
        frame.setVisible(true);
        Platform.runLater(new Runnable() {
            public void run() {
                initPanel(fxPanel, label);
            }
        });
    }

    private static void initPanel(JFXPanel fxPanel, final JLabel label) {
        HBox box = new HBox(10);
        Button play = new Button("Play");
        play.setMinWidth(100);
        Media media = new Media("http://zhangmenshiting2.baidu.com/data2/music/5738288/5738288.mp3?xcode=521977a536ddf98100f94af7f4eefafa&mid=0.39430558284862");
        final MediaPlayer player = new MediaPlayer(media);
        play.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                player.play();
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        label.setText(player.getMedia().getSource());
                    }
                });
            }
        });
        box.getChildren().addAll(play);
        fxPanel.setScene(new Scene(box, 400, 50));
    }
}
