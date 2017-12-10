/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author chengfu
 */
public class UseGlassPane {
    
    public void waitToLoad() {
         final JFrame frame = new JFrame();
         LoadingPane pane = new LoadingPane();
         frame.setGlassPane(pane);
         pane.setVisible(true);
         JButton button = new JButton("Button");
         button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(frame.getGlassPane().isVisible());
                System.out.println("clicked");
            }
             
         });
         frame.add(button, BorderLayout.NORTH);
         frame.setSize(400, 300);
        frame.setVisible(true);
    }
    
    private static class LoadingPane extends JComponent {
        public LoadingPane() {
            addMouseListener(new MouseAdapter(){});
        }
        
        public void paintComponent(Graphics g) {
           g.drawString("Loading...", getWidth() /2 , getHeight() / 2);
        } 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UseGlassPane ucp = new UseGlassPane();
        ucp.waitToLoad();
    }
}
