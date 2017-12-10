/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.event;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author chengfu
 */
public class UseEventMask {
    
    private static class NoMouseComponent extends Component {

        public NoMouseComponent() {
            super();
            disableMouseEvent();
        }
        
        private void disableMouseEvent() {
            disableEvents(AWTEvent.MOUSE_EVENT_MASK);
        }
    }
    
    public void testMouseEvent() {
        Frame frame = new Frame();
        frame.setSize(400, 300);
        NoMouseComponent component = new NoMouseComponent();
        frame.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("鼠标按下。");
            }
            
        });
        frame.add(component, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UseEventMask uem = new UseEventMask();
        uem.testMouseEvent();
    }
}