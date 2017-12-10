package com.java7book.chapter8.asm;

import javax.swing.JFrame;
import com.java7book.chapter8.asm.DrawingComponent;

public class DrawLines extends JFrame {
    
    public DrawLines() {
        setTitle("图形绘制结果");
        setSize(800, 600);
        add(new DrawingComponent());
    }
    
    public static void main(String[] args) {
        DrawLines drawLines = new DrawLines();
        drawLines.setVisible(true);
    }

}
