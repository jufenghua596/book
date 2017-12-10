/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.charset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author chengfu
 */
public class SearchAndExtract {

    public void search(String keyword) throws IOException {
        String url = "http://www.baidu.com/s?wd=" + URLEncoder.encode(keyword, "GB18030");
        InputStream input = new URL(url).openStream();
        String content = streamToString(input);
        System.out.println(content);
    }

    private String streamToString(InputStream input) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, "GB18030"));
        char[] buffer = new char[32 * 1024];
        int len = -1;
        while ((len = reader.read(buffer)) != -1) {
            builder.append(buffer, 0, len);
        }
        return builder.toString();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        SearchAndExtract sae = new SearchAndExtract();
        sae.search("你好");
    }
}
