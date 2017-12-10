/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.filechannel;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author chengfu
 */
public class LoadWebPage {

    public void loadWebPage(String url) throws IOException {
        try (FileChannel destChannel = FileChannel.open(Paths.get("content.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            InputStream input = new URL(url).openStream();
            ReadableByteChannel srcChannel = Channels.newChannel(input);
            destChannel.transferFrom(srcChannel, 0, Integer.MAX_VALUE);
        }
    }

        /**
         * @param args the command line arguments
         */
    

    public static void main(String[] args) throws IOException {
        LoadWebPage lwp = new LoadWebPage();
        lwp.loadWebPage("http://www.baidu.com");
    }
}
