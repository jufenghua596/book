package com.java7book.chapter8.compiler;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CompilerMain {

	public static void main(String[] args) throws IOException {
		//JavacCompiler javac = new JavacCompiler();
		Path src = Paths.get("src", "com", "java7book", "chapter8", "SampleClass.java").toAbsolutePath();
		Path output = Paths.get("classes").toAbsolutePath();
		//javac.compile(src, output);
		JavacAPICompiler javacApi = new JavacAPICompiler();
		//javacApi.compile(src, output);
		JavaCompilerAPICompiler javaCompilerAPI = new JavaCompilerAPICompiler();
		javaCompilerAPI.compile(src, output);
	}

}
