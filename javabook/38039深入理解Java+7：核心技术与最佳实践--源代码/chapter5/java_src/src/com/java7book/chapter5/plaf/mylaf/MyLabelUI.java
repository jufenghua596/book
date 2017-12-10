/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.plaf.mylaf;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicLabelUI;

/**
 *
 * @author chengfu
 */
public class MyLabelUI extends BasicLabelUI {
    public static ComponentUI createUI(JComponent c) {
       return new MyLabelUI();
    }

    public void paint(Graphics g, JComponent c) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
        g.setColor(Color.WHITE);
        JLabel label = (JLabel) c;
        g.drawString(label.getText(), 0, label.getHeight() / 2);
    }
}
