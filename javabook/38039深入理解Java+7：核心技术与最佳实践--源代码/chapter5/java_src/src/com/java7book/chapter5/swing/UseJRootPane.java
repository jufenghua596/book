/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author chengfu
 */
public class UseJRootPane {
    
    public void changeMenuPosition() {
        JFrame frame = new JFrame();
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("Open");
        menu.add(menuItem);
        menubar.add(menu);
        //frame.setJMenuBar(menubar);
        JLayeredPane pane = frame.getLayeredPane();
        pane.setLayout(new BorderLayout());
       //frame.getRootPane().setLayout(new BorderLayout());
       pane.add(menubar, BorderLayout.SOUTH);
       //Container contentPane = frame.getRootPane().getContentPane();
       //frame.getRootPane().remove(contentPane);
       //pane.add(contentPane, BorderLayout.CENTER);
        frame.add(new JButton("Button"));
        System.out.println(frame.getRootPane().getLayout());
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       UseJRootPane ujrp = new UseJRootPane();
       ujrp.changeMenuPosition();
    }
}
