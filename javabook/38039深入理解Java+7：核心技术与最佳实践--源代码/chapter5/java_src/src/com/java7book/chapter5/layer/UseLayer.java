/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.layer;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.plaf.LayerUI;

/**
 *
 * @author chengfu
 */
public class UseLayer {

    public void useHighlight() {
        final JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(2, 1));
        frame.add(new JLabel("标签"));
        JButton button = new JButton("按钮");
        final JLayer<? extends Component> layer = new JLayer<>(button);
        //final LayerUI layerUI = new HighlightLayerUI();
        final LayerUI layerUI = new MouseMonitorLayerUI();
        final LayerUI defaultUI = new LayerUI();
        layer.setUI(layerUI);
        frame.add(layer);
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
               // layer.setUI(layerUI);
            }

            public void mouseExited(MouseEvent e) {
               // layer.setUI(defaultUI);
            }
        });
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("click");
            }
            
        });
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UseLayer ul = new UseLayer();
        ul.useHighlight();
    }
}
