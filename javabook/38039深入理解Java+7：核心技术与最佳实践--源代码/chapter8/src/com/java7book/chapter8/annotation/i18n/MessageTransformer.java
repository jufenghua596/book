package com.java7book.chapter8.annotation.i18n;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class MessageTransformer implements Opcodes {
    public static void transform(Path path) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.class")) {
            for (Path classFile : stream) {
                processClassFile(classFile);
            }
        }
    }
    
    private static void processClassFile(Path classFile) throws IOException {
        byte[] classData = Files.readAllBytes(classFile);
        ClassReader reader = new ClassReader(classData);
        ClassNode node = new ClassNode();
        reader.accept(node, 0);
        Iterator iterator = node.methods.iterator();
        while (iterator.hasNext()) {
            MethodNode mn = (MethodNode) iterator.next();
            List annotations = mn.visibleAnnotations;
            if (annotations != null) {
                for (Object obj : annotations) {
                    AnnotationNode an = (AnnotationNode) obj;
                    if ("Lcom/java7book/chapter8/annotation/i18n/Message;".equals(an.desc)) {
                        List values = an.values;
                        String key = null;
                        int len = values.size();
                        for (int i = 0; i < len; i+= 2) {
                            if ("key".equals(values.get(i))) {
                                key = (String) values.get(i + 1);
                            }
                        }
                        updateMethodNode(mn, key);
                    }
                }
            }
        }
        ClassWriter writer = new ClassWriter(0);
        node.accept(writer);
        byte[] transformed = writer.toByteArray();
        Files.write(classFile, transformed);
    }
    
    private static void updateMethodNode(MethodNode mn, String key) {
        InsnList instructions = mn.instructions;
        Iterator iterator = instructions.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        instructions.add(new LdcInsnNode(key));
        instructions.add(new VarInsnNode(ALOAD, 1));
        instructions.add(new MethodInsnNode(INVOKESTATIC, "com/java7book/chapter8/annotation/i18n/Messages", "getMessage", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;"));
        instructions.add(new InsnNode(ARETURN));
        mn.maxStack = 2;
        mn.maxLocals = 2;
    }
    
    public static void main(String[] args) {
        try {
            MessageTransformer.transform(Paths.get("bin", "com", "java7book", "chapter8", "annotation", "i18n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
