package com.java7book.chapter11.sync;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

public class WebPageImageDownloader {
    private final Phaser phaser = new Phaser(1);
    private final Pattern imageUrlPattern = Pattern.compile("src=['\"]?(.*?(\\.jpg|\\.gif|\\.png))['\"]?[\\s>]+", Pattern.CASE_INSENSITIVE);
    public void download(URL url, final Path path, Charset charset) throws IOException {
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        String content = getContent(url, charset);
        List<URL> imageUrls = extractImageUrls(content);
        for (final URL imageUrl : imageUrls) {
            phaser.register();
            new Thread() {
                public void run() {
                    phaser.arriveAndAwaitAdvance();
                    try {
                    InputStream is = imageUrl.openStream();
                    Files.copy(is, getSavedPath(path, imageUrl), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        phaser.arriveAndDeregister();
                    }
                }
            }.start();
        }
        phaser.arriveAndAwaitAdvance();
        phaser.arriveAndAwaitAdvance();
        phaser.arriveAndDeregister();
    }
    private String getContent(URL url, Charset charset) throws IOException {
        InputStream is = url.openStream();
        return IOUtils.toString(new InputStreamReader(is, charset.name()));
    }
    private List<URL> extractImageUrls(String content) {
        List<URL> result = new ArrayList<URL>();
        Matcher matcher = imageUrlPattern.matcher(content);
        while (matcher.find()) {
            try {
                result.add(new URL(matcher.group(1)));
            } catch (MalformedURLException e) {
               //忽略
            }
        }
        return result;
    }
    private Path getSavedPath(Path parent, URL url) {
        String urlString = url.toString();
        int index = urlString.lastIndexOf("/");
        String fileName = urlString.substring(index + 1);
        return parent.resolve(fileName);
    }
    
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");
        WebPageImageDownloader downloader = new WebPageImageDownloader();
        downloader.download(url, Paths.get("imgs"), Charset.forName("GB2312"));
    }
}
