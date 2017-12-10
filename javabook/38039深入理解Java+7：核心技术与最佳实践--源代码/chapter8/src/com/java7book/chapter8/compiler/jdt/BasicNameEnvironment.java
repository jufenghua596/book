package com.java7book.chapter8.compiler.jdt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFormatException;
import org.eclipse.jdt.internal.compiler.env.INameEnvironment;
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;

public class BasicNameEnvironment implements INameEnvironment {

    @Override
    public NameEnvironmentAnswer findType(char[][] compoundTypeName) {
        final StringBuffer result = new StringBuffer();
        for (int i = 0; i < compoundTypeName.length; i++) {
            if (i != 0) {
                result.append('.');
            }
            result.append(compoundTypeName[i]);
        }
        return findType(result.toString());
    }

    @Override
    public NameEnvironmentAnswer findType(char[] typeName,
            char[][] packageName) {
        final StringBuffer result = new StringBuffer();
        for (int i = 0; i < packageName.length; i++) {
            result.append(packageName[i]);
            result.append('.');
        }
        result.append(typeName);
        return findType(result.toString());
    }
    
    private NameEnvironmentAnswer findType(String name) {
        byte[] bytes = getClassDefinition(name);
        if (bytes == null) {
            return null;
        }
        try {
            ClassFileReader classFileReader = new ClassFileReader(bytes, name.toCharArray(), true);
            return new NameEnvironmentAnswer(classFileReader, null);
        } catch (ClassFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isPackage(char[][] parentPackageName, char[] packageName) {
        StringBuilder sb = new StringBuilder();
        if (parentPackageName != null) {
            for (char[] p : parentPackageName) {
                sb.append(new String(p));
                sb.append(".");
            }
        }
        sb.append(new String(packageName));
        String name = sb.toString();
        if (OnlineJudge.packagesCache.containsKey(name)) {
            return OnlineJudge.packagesCache.get(name).booleanValue();
        }
        if (this.getClassDefinition(name) != null) {
            OnlineJudge.packagesCache.put(name, false);
            return false;
        }
        OnlineJudge.packagesCache.put(name, true);
        return true;
    }
    
    private byte[] getClassDefinition(String name) {
        name = name.replace(".", "/") + ".class";
        InputStream is = ClassLoader.getSystemResourceAsStream(name);
        if (is == null) {
            return null;
        }
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int count;
            while ((count = is.read(buffer, 0, buffer.length)) > 0) {
                os.write(buffer, 0, count);
            }
            return os.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void cleanup() {
        
    }
    
}