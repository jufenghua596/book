/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.plaf;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author chengfu
 */
public class SelectPlaf {

    public void selectPlaf() {
        final JFrame frame = new JFrame();
        UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
        JComboBox combo = new JComboBox(lafs);
        combo.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (ItemEvent.SELECTED == e.getStateChange()) {
                    UIManager.LookAndFeelInfo info = (UIManager.LookAndFeelInfo) e.getItem();
                    try {
                        UIManager.setLookAndFeel(info.getClassName());
                        SwingUtilities.updateComponentTreeUI(frame);
                    } catch (Exception ex) {
                    }
                }
            }
        });
        frame.add(combo, BorderLayout.NORTH);
        frame.add(new JButton("按钮"), BorderLayout.SOUTH);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                SelectPlaf sp = new SelectPlaf();
                sp.selectPlaf();
            }
        });
    }
}
