/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.layer;

import java.awt.AWTEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JLayer;
import javax.swing.plaf.LayerUI;

/**
 *
 * @author chengfu
 */
public class MouseMonitorLayerUI extends LayerUI {

    public void installUI(JComponent c) {
        super.installUI(c);
        JLayer layer = (JLayer) c;
        layer.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK);
        
        c.addMouseListener(new MouseAdapter(){});
    }

    public void uninstallUI(JComponent c) {
        super.uninstallUI(c);
        JLayer layer = (JLayer) c;
        layer.setLayerEventMask(0);
    }
    
    public void processMouseEvent(MouseEvent e, JLayer l) {
       System.out.println(e.paramString());
    }
}
