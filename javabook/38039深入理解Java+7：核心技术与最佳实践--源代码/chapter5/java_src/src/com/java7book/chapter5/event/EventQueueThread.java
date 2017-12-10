/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.event;

import java.awt.AWTEvent;
import java.awt.ActiveEvent;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author chengfu
 */
public class EventQueueThread {

    private static class CustomEvent extends AWTEvent implements ActiveEvent {

        public CustomEvent() {
            super(new Object(), AWTEvent.RESERVED_ID_MAX + 1);
        }

        public void dispatch() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public void testThread() {
        Frame frame = new Frame();
        frame.setSize(400, 300);
        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(Thread.currentThread().getName());
            }
        });
        
        EventQueue queue = new EventQueue();
        AWTEvent customEvent = new CustomEvent();
        queue.postEvent(customEvent);
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueueThread eqt = new EventQueueThread();
        eqt.testThread();
    }
}
