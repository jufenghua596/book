/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.event;

import java.awt.AWTEvent;
import java.awt.ActiveEvent;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

/**
 *
 * @author chengfu
 */
public class UseEventQueue {

    private static class MyEvent extends AWTEvent implements ActiveEvent {

        private String content;

        public MyEvent(String content) {
            super(content, AWTEvent.RESERVED_ID_MAX + 1);
            this.content = content;
        }

        public void dispatch() {
            System.out.println("字符串长度为：" + content.length());
        }
    }

    public void useEventQueue() {
        Frame frame = new Frame();
        frame.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        EventQueue queue = toolkit.getSystemEventQueue();
        queue.postEvent(new MyEvent("Hello"));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UseEventQueue ueq = new UseEventQueue();
        ueq.useEventQueue();
    }
}
