package com.java7book.chapter7.jni;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class WebPageDownloader {
	
	public static String getContent(String urlString) throws IOException {
		URL url = new URL(urlString);
		InputStream input = url.openStream();
		return streamToString(input);
	}
	
	private static String streamToString(InputStream is) throws IOException {
		final char[] buffer = new char[0x10000];
		StringBuilder out = new StringBuilder();
		Reader in = new InputStreamReader(is, "UTF-8");
		int read;
		do {
		  read = in.read(buffer, 0, buffer.length);
		  if (read>0) {
		    out.append(buffer, 0, read);
		  }
		} while (read>=0);
		return out.toString();
	}
}
