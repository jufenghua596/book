/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.window;

import java.awt.Frame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author chengfu
 */
public class TranslucentWindow {
    
    public void createTranslucentWindow() {
        final Frame frame = new Frame();
        frame.setUndecorated(true);
        frame.setSize(400, 300);
        final JSlider slider = new JSlider(0, 100, 80);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                frame.setOpacity(slider.getValue() / 100.0f);
            }
        });
        frame.add(slider);
        frame.setOpacity(0.8f);
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TranslucentWindow tw = new TranslucentWindow();
        tw.createTranslucentWindow();
    }
}
