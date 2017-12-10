package com.java7book.chapter7.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringIntern {

	private List<String> list = new ArrayList<String>();

	public void useInternString() {
		Random random = new Random();
		for (int i = 0; i < 200; i++) {
			char[] data = new char[128 * 1024];
			for (int j = 0; j < data.length; j++) {
				data[j] = (char) random.nextInt(32768);
			}
			list.add((new String(data)).intern());
		}
		System.out.println(list.size());
	}

	public static void main(String[] args) {
		StringIntern si = new StringIntern();
		si.useInternString();
	}

}
