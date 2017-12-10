package com.java7book.chapter8.compiler.jdt;

import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;

public class StringCompilationUnit implements ICompilationUnit {

    private String fileName;
    private char[] typeName;
    private char[][] packageName;
    private String content;
    
    public StringCompilationUnit(String className, String content) {
        this.content = content;
        if (className.contains("$")) {
            className = className.substring(0, className.indexOf("$"));
        }
        fileName = className.replace('.', '/') + ".java";
        int pos = className.lastIndexOf('.');
        if (pos > 0) {
            typeName = className.substring(pos + 1).toCharArray();
        } else {
            typeName = className.toCharArray();
        }
        String[] names = className.split("\\.");
        packageName = new char[names.length - 1][];
        for (int i = 0; i < packageName.length; i++) {
            packageName[i] = names[i].toCharArray();
        }
    }
    
    public char[] getFileName() {
        return fileName.toCharArray();
    }

    public char[] getContents() {
        return content.toCharArray();
    }

    public char[] getMainTypeName() {
        return typeName;
    }

    public char[][] getPackageName() {
        return packageName;
    }
}