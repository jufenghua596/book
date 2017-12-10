package com.java7book.chapter8.compiler;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavacAPICompiler {
	public void compile(Path src, Path output) throws CompileException {
		String[] args = new String[] {src.toString(), "-d", output.toString()};
		try {
			PrintWriter out = new PrintWriter(Paths.get("output.txt").toFile());
			com.sun.tools.javac.Main.compile(args, out);
		} catch (FileNotFoundException e) {
			throw new CompileException(e);
		}
	}
}
