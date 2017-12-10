/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author chengfu
 */
public class UseContainer {

    public void useContainer() {
        final JFrame frame = new JFrame();
        frame.setSize(400, 300);
        JButton button = new JButton("Remove");
        frame.add(button, BorderLayout.NORTH);
        final JLabel label = new JLabel("Label");
        frame.add(label, BorderLayout.SOUTH);
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frame.remove(label);
                //invalidate();
                System.out.println(frame.isValid());
                frame.add(new JLabel("AAA"));
                frame.revalidate();
            }
        });
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                UseContainer uc = new UseContainer();
                uc.useContainer();
            }
        });

    }
}
