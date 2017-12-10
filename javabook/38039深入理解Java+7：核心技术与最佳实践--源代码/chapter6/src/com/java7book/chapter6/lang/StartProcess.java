package com.java7book.chapter6.lang;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class StartProcess {
	
	public void startProcessNormal() throws IOException {
		ProcessBuilder pb =
				   new ProcessBuilder("cmd.exe", "/c", "netstat", "-a");
		Process process = pb.start();
		InputStream input = process.getInputStream();
		Files.copy(input, Paths.get("netstat.txt"), StandardCopyOption.REPLACE_EXISTING);
	}

	public void listProcesses() throws IOException {
		ProcessBuilder pb =
				   new ProcessBuilder("wmic", "process");
		File output = Paths.get("tasks.txt").toFile();
		pb.redirectOutput(output);
		pb.start();
	}
	
	public void dir() throws IOException {
		ProcessBuilder pb =
				   new ProcessBuilder("cmd.exe", "/c", "dir");
		pb.redirectOutput(Redirect.INHERIT);
		pb.start();
	}
	
	public static void main(String[] args) {
		StartProcess sp = new StartProcess();
		try {
			sp.startProcessNormal();
			sp.dir();
			sp.listProcesses();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
