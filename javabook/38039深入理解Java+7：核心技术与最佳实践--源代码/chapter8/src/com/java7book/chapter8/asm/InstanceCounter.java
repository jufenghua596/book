package com.java7book.chapter8.asm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class InstanceCounter extends ClassAdapter implements Opcodes{
    
    private static class UpdateInstanceCounterAdapter extends MethodAdapter implements Opcodes {
        private String className;
        
        public UpdateInstanceCounterAdapter(String className, MethodVisitor mv) {
            super(mv);
            this.className = className;
        }

        public void visitInsn(int opcode) {
            if ((opcode >= IRETURN && opcode <= RETURN) || opcode == ATHROW) {
                mv.visitFieldInsn(GETSTATIC, className, "instanceCount", "I");
                mv.visitInsn(ICONST_1);
                mv.visitInsn(IADD);
                mv.visitFieldInsn(PUTSTATIC, className, "instanceCount", "I");
            }
            mv.visitInsn(opcode);
        }

        public void visitMaxs(int maxStack, int maxLocals) {
            mv.visitMaxs(maxStack + 2, maxLocals);
        }
    }
    
    private String className;
    
    public InstanceCounter(ClassVisitor cv) {
        super(cv);
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        cv.visit(version, access, name, signature, superName, interfaces);
        className = name;
        FieldVisitor fv = cv.visitField(ACC_PUBLIC + ACC_STATIC, "instanceCount", "I", null, null);
        fv.visitEnd();
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        if ("<init>".equals(name)) {
            mv = new UpdateInstanceCounterAdapter(className, mv);
        }
        return mv;
    } 
    
    public static void main(String[] args) throws IOException {
        ClassReader reader = new ClassReader("com.java7book.chapter8.asm.CreatedObject");
        ClassWriter writer = new ClassWriter(0);
        InstanceCounter counter = new InstanceCounter(writer);
        reader.accept(counter, 0);
        byte[] byteCode = writer.toByteArray();
        Files.write(Paths.get("bin", "com","java7book", "chapter8", "asm", "CreatedObject.class"), byteCode);
    }
}
