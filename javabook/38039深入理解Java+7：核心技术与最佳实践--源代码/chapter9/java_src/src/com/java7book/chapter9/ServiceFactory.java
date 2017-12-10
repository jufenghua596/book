package com.java7book.chapter9;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ServiceFactory {
    public static Versionized getService(String className, String version) throws Exception {
        Path path = Paths.get("service", version);
        FileSystemClassLoader loader = new FileSystemClassLoader(path);
        Class<?> clazz = loader.loadClass(className);
        return (Versionized) clazz.newInstance();
    }
}
