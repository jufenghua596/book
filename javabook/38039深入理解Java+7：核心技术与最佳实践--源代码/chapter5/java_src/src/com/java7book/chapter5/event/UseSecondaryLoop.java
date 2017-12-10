/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.event;

import java.awt.EventQueue;
import java.awt.SecondaryLoop;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author chengfu
 */
public class UseSecondaryLoop {

    private static class WorkerThread extends Thread {
        private SecondaryLoop loop;
        public WorkerThread(SecondaryLoop loop) {
            this.loop = loop;
        }

        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
            }
            loop.exit();
        }
    }

    public void useLoop() {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
                SecondaryLoop loop = queue.createSecondaryLoop();
                WorkerThread thread = new WorkerThread(loop);
                thread.start();
                loop.enter();
            }
        });
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UseSecondaryLoop usl = new UseSecondaryLoop();
        usl.useLoop();
    }
}
