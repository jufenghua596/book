package com.java7book.chapter2.invoke.interceptors;

import java.io.IOException;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import java.nio.file.Files;
import java.io.InputStream;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.CallSite;
import java.lang.invoke.MethodType;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodHandle;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

/**
 *
 * @author chengfu
 */
public class LoggingProcessor {

    private static final MethodHandle BSM =
            new MethodHandle(MH_INVOKESTATIC,
            LoggingBootstrap.class.getName().replace('.', '/'),
            "bootstrap",
            MethodType.methodType(
            CallSite.class, Lookup.class, String.class, MethodType.class, Object[].class).toMethodDescriptorString());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("build", "classes", "com\\java7book\\chapter2\\invoke\\interceptors\\SimpleClass.class");
        InputStream input = Files.newInputStream(path);
        ClassReader reader = new ClassReader(input);
        ClassWriter writer = new ClassWriter(reader, 0);
        reader.accept(new ClassAdapter(writer) {

            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                 System.out.println("METHOD -> " + name + " - " + desc + " - " + signature);
                
                MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
                return new MethodAdapter(mv) {

                    @Override
                    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
                        System.out.println(owner + " - " + name + " - " + desc);
                        
                        if (opcode == INVOKESPECIAL) {
                            super.visitMethodInsn(opcode, owner, name, desc);
                            return;
                        } else {
                            super.visitInvokeDynamicInsn(name, desc, BSM, new Object[] {desc});
                            return;
                        }
                    }
                };
            }
        }, 0);
        input.close();
        Files.write(path, writer.toByteArray());
    }
}
