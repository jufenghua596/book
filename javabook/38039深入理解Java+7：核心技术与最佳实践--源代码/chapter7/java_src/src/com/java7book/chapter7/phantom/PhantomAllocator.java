package com.java7book.chapter7.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomAllocator {
	private byte[] data = null;

	private ReferenceQueue<byte[]> queue = new ReferenceQueue<byte[]>();

	private Reference<? extends byte[]> ref = null;

	public byte[] get(int size) {
		if (ref == null) {
			data = new byte[size];
			ref = new PhantomReference<byte[]>(data, queue);
		}
		else {
			data = null;
			System.gc();
			try {
				ref = queue.remove();
				ref.clear();
				ref = null;
				System.gc();
				data = new byte[size];
				ref = new PhantomReference<byte[]>(data, queue);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public static void main(String[] args) {
		PhantomAllocator cache = new PhantomAllocator();
		int runs = 20;
		int size = 5 * 1000 * 1000;
		for (int i = 0; i < runs; i++) {
			cache.get(size + i);
		}
	}
}
