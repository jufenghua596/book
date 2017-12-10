package com.java7book.chapter7.ref;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class UseFileEditor {

	public static void main(String[] args) throws IOException {
		FileEditor editor = new FileEditor();
		/*editor.switchTo("lib/jnaerator-0.9.8-shaded.jar");
		editor.useFile();
		editor.switchTo("data.bin");
		editor.useFile();
		editor.switchTo("data2.bin");
		editor.useFile();
		editor.switchTo("data3.bin");
		editor.useFile();
		editor.switchTo("data.bin");
		editor.useFile();*/
		
		DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("C:", "BornToWin"));
		Iterator<Path> iterator = directoryStream.iterator();
		String previous = null, next = null;
		while (iterator.hasNext()) {
			next = iterator.next().toString();
			editor.switchTo(next);
			editor.useFile();
			if (previous != null) {
				editor.switchTo(previous);
				editor.useFile();
			}
			previous = next;
		}
	}

}
