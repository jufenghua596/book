/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.window;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author chengfu
 */
public class ShapedWindow {

    public void createShapedWindow() {
        Frame frame = new Frame();
        frame.setUndecorated(true);
        Shape shape = new Ellipse2D.Float(0, 0, 400, 300);
        frame.setShape(shape);
        Label label = new Label("Hello World!");
        frame.add(label);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ShapedWindow sw = new ShapedWindow();
        sw.createShapedWindow();
    }
}
