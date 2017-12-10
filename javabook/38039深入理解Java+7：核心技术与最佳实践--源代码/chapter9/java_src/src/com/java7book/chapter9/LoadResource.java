package com.java7book.chapter9;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadResource {
    public Properties loadConfig() throws IOException {
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream input = loader.getResourceAsStream("com/java7book/chapter9/config.properties");
        if (input == null) {
            throw new IOException("找不到配置文件。");
        }
        Properties props = new Properties();
        props.load(input);
        return props;
    }
    
    public static void main(String[] args) throws IOException {
        LoadResource lr = new LoadResource();
        Properties props = lr.loadConfig();
        System.out.println(props.getProperty("mode"));
    }
}
