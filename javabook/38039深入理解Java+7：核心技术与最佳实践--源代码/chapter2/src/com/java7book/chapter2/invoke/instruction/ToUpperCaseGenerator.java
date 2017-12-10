/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.instruction;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.lang.invoke.CallSite;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodHandle;
import org.objectweb.asm.MethodVisitor;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

import static org.objectweb.asm.Opcodes.*;

/**
 *
 * @author chengfu
 */
public class ToUpperCaseGenerator {
    
    private static final MethodHandle BSM =
            new MethodHandle(MH_INVOKESTATIC,
            ToUpperCase.class.getName().replace('.', '/'),
            "bootstrap",
            MethodType.methodType(
            CallSite.class, Lookup.class, String.class, MethodType.class, String.class).toMethodDescriptorString());


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(V1_7, ACC_PUBLIC | ACC_SUPER, "ToUpperCaseMain", null, "java/lang/Object", null);

        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC | ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitInvokeDynamicInsn("toUpperCase", "()Ljava/lang/String;", BSM, "Hello");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();

        cw.visitEnd();

        Files.write(Paths.get("build","classes","ToUpperCaseMain.class"), cw.toByteArray());
    }
}
