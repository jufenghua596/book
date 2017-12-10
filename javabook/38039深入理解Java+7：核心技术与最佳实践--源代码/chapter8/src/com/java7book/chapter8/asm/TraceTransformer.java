package com.java7book.chapter8.asm;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class TraceTransformer implements ClassFileTransformer {
    public byte[] transform(ClassLoader loader, String className,
            Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
            byte[] classfileBuffer) throws IllegalClassFormatException {
        ClassReader reader = new ClassReader(classfileBuffer);
        ClassWriter writer = new ClassWriter(0);
        ClassAdapter adapter = new ClassAdapter(writer){
            public MethodVisitor visitMethod(int access, final String name, String desc, String signature, String[] exceptions) {
                MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
                return new MethodAdapter(mv) {
                    public void visitCode() {
                        mv.visitCode();
                        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                        mv.visitLdcInsn("进入方法：" + name);
                        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
                    }

                    public void visitMaxs(int maxStack, int maxLocals) {
                        mv.visitMaxs(maxStack + 2, maxLocals);
                    }
                };
            }
        };
        reader.accept(adapter, 0);
        return writer.toByteArray();
    }
}
