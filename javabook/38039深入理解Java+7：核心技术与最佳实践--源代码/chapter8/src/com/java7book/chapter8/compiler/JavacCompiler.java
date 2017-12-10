package com.java7book.chapter8.compiler;

import java.io.IOException;
import java.nio.file.Path;

public class JavacCompiler {	
	public void compile(Path src, Path output) throws CompileException {
		ProcessBuilder pb =
				   new ProcessBuilder("javac.exe", src.toString(), "-d", output.toString());
		try {
			pb.start();
		} catch (IOException e) {
			throw new CompileException(e);
		}
	}
}
