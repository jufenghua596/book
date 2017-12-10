/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.layer;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.plaf.LayerUI;

/**
 *
 * @author chengfu
 */
public class HighlightLayerUI extends LayerUI {
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        g.setColor(Color.red);
        g.drawRect(0, 0, c.getWidth() - 1, c.getHeight() - 1);
    }
}
