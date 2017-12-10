package com.java7book.chapter6.beans;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UseXMLEncoder {

	public void xmlEncode() throws IOException {
		OutputStream output = Files.newOutputStream(Paths.get("result.xml"), StandardOpenOption.CREATE_NEW);
		try (XMLEncoder encoder = new XMLEncoder(output, StandardCharsets.UTF_8.name(), true, 0)) {
			encoder.writeObject(new MyBean());
		}
	}

	public static void main(String[] args) {
		UseXMLEncoder uxe = new UseXMLEncoder();
		try {
			uxe.xmlEncode();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
