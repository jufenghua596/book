package com.java7book.chapter8.compiler;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Calculator extends ClassLoader {
	public double calculate(String expr) throws Exception {
		String className = "CalculatorMain";
		String methodName = "calculate";
		String source = "public class " + className + " { public static double " + methodName + "() { return " + expr + "; } }";
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		JavaFileObject sourceObject = new StringSourceJavaFileObject(className, source);
		Iterable<? extends JavaFileObject> fileObjects = Arrays.asList(sourceObject);
		Path output = Files.createTempDirectory("calculator");
		Iterable<String> options = Arrays.asList("-d", output.toString());
		CompilationTask task = compiler.getTask(null, fileManager, null, options, null, fileObjects);
		boolean result = task.call();
		if (result) {
			byte[] classData = Files.readAllBytes(Paths.get(output.toString(), className + ".class"));
			Class<?> clazz = defineClass(className, classData, 0, classData.length);
			Method method = clazz.getMethod(methodName);
			Object value = method.invoke(null);
			return (Double) value;
		}
		else {
			throw new Exception("无法识别的表达式。");
		}
	}
	
	public static void main(String[] args) throws Exception {
		String expr = "(3+4)*7-1.2*3";
		Calculator calculator = new Calculator();
		System.out.println(calculator.calculate(expr));
	}
}
