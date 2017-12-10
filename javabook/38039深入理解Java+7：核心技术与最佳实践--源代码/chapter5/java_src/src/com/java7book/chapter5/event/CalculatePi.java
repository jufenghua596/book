/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.event;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Label;

/**
 *
 * @author chengfu
 */
public class CalculatePi {

    public void calculate() {
        Frame frame = new Frame();
        Label label = new Label();
        frame.add(label);
        frame.setSize(400, 300);
        frame.setVisible(true);
        new CalculateThread(label).start();
    }

    private static class CalculateThread extends Thread {
        double sum = 0.0, term, sign = 1.0;
        int N = 30 * 1000 * 1000;
        private Label label;

        public CalculateThread(Label label) {
            this.label = label;
        }

        public void run() {
            for (int k = 0; k < N; k++) {
                term = 1.0 / (2.0 * k + 1.0);
                sum = sum + sign * term;
                if (k % (N / 100) == 0) {
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            label.setText(Double.toString(4 * sum));
                        }
                    });
                }
                sign = -sign;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalculatePi cp = new CalculatePi();
        cp.calculate();
    }
}
