package com.java7book.chapter7.gc;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.V1_7;

import org.objectweb.asm.ClassWriter;

public class LoadClass extends ClassLoader {

	public void loadManyClasses() {
		int num = 50000;
		String classNamePrefix = "ManyClass";
		for (int i = 0; i < num; i++) {
			String className = classNamePrefix + i;
			createAndLoadClass(className);
		}
	}

	private void createAndLoadClass(String className) {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cw.visit(V1_7, ACC_PUBLIC | ACC_SUPER, className, null,
				"java/lang/Object", null);
		cw.visitEnd();
		byte[] classData = cw.toByteArray();
		this.defineClass(className, classData, 0, classData.length);
	}

	public static void main(String[] args) {
		LoadClass lc = new LoadClass();
		lc.loadManyClasses();
	}

}
