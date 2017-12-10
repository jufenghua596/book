package com.java7book.chapter7.phantom;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoftCache {
	
	private List<SoftReference<byte[]>> refs = new ArrayList<SoftReference<byte[]>>();

    public byte[] get(int size) {
    	byte[] data = new byte[size];
    	SoftReference<byte[]> softRef = new SoftReference<byte[]>(data);
    	data = null;
    	refs.add(softRef);
    	return softRef.get();
    }
    
    public static void main(String[] args) {
    	SoftCache cache = new SoftCache();
		int runs = 10;
		int size = 5 * 1000 * 1000;
		Map<Integer, byte[]> data = new HashMap<>();
		for (int i = 0; i < runs; i++) {
			//data.put(i, cache.get(size));
			cache.get(size);
		}
    }
}
