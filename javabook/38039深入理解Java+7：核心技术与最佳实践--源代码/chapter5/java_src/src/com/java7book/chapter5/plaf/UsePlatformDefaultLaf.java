/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.plaf;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

/**
 *
 * @author chengfu
 */
public class UsePlatformDefaultLaf {

    public void useDefaultLaf() throws Exception {
        final JFrame frame = new JFrame();
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        frame.setSize(400, 300);
        frame.add(new JLabel("标签"));
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        UsePlatformDefaultLaf updf = new UsePlatformDefaultLaf();
        updf.useDefaultLaf();
    }
}
