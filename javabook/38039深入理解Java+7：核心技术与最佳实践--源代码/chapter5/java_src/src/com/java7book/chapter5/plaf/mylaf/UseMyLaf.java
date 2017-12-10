/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.plaf.mylaf;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author chengfu
 */
public class UseMyLaf {

    public void useMyLaf() {
        try {
            UIManager.setLookAndFeel(new MyLookAndFeel());

        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        System.out.println(UIManager.get("LabelUI"));
        JFrame frame = new JFrame();
        JLabel label = new JLabel("标签");

        //label.setUI(new MyLabelUI());
        frame.add(label);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UseMyLaf uml = new UseMyLaf();
        uml.useMyLaf();
    }
}
