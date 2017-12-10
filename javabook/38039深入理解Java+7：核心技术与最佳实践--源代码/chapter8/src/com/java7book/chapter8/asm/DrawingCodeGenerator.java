package com.java7book.chapter8.asm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class DrawingCodeGenerator implements Opcodes {
    private ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
    private MethodVisitor mv = null;
    private int currentX = 0;
    private int currentY = 0;
    
    public byte[] generate(String sourceCode) throws IOException {
        generateClassInfo();
        generatePaintMethod(sourceCode);
        writer.visitEnd();
        return writer.toByteArray();
    }
    
    private void generateClassInfo() {
        writer.visit(V1_7, ACC_PUBLIC + ACC_SUPER, "com/java7book/chapter8/asm/DrawingComponent", null, "java/awt/Component", null);
        mv = writer.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/awt/Component", "<init>", "()V");
        mv.visitInsn(RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();
    }
    
    private void generatePaintMethod(String sourceCode) throws IOException {
        mv = writer.visitMethod(ACC_PUBLIC, "paint", "(Ljava/awt/Graphics;)V", null, null);
        mv.visitCode();
        BufferedReader reader = new BufferedReader(new StringReader(sourceCode));
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("MOVETO")) {
                handleMoveTo(line);
            }
            else if (line.startsWith("LINETO")) {
                handleLineTo(line);
            }
        }
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }
    
    private void handleMoveTo(String line) {
        String pos = line.substring("MOVETO ".length());
        String[] parts = pos.split(" ");
        currentX = Integer.parseInt(parts[0]);
        currentY = Integer.parseInt(parts[1]);
    }
    
    private void handleLineTo(String line) {
        String pos = line.substring("LINETO ".length());
        String[] parts = pos.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitIntInsn(BIPUSH, currentX);
        mv.visitIntInsn(BIPUSH, currentY);
        mv.visitIntInsn(BIPUSH, x);
        mv.visitIntInsn(BIPUSH, y);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/awt/Graphics", "drawLine", "(IIII)V");
        currentX = x;
        currentY = y;
    }
    
    public static void main(String[] args) throws IOException {
        DrawingCodeGenerator generator = new DrawingCodeGenerator();
        String langSourceCode = "MOVETO 30 30\r\nLINETO 30 100\r\nLINETO 70 100\r\nLINETO 30 30\r\nLINETO 40 120";
        byte[] byteCode = generator.generate(langSourceCode);
        Files.write(Paths.get("bin", "com","java7book", "chapter8", "asm", "DrawingComponent.class"), byteCode);
    }
}
