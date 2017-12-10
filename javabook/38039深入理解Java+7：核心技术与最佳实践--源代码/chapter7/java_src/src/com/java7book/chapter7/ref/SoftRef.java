package com.java7book.chapter7.ref;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

class StrongImageData {
	private String path;
	
	private byte[] data;
	
	public StrongImageData(String path) {
		this.path = path;
		this.data = readImage();
	}
	
	public String getPath() {
		return path;
	}
	
	private byte[] readImage() {
		return new byte[1024 * 1024];
	}
	
	public byte[] getData() {
		return data;
	}
}

class ImageData {
	private String path;
	
	private SoftReference<byte[]> dataRef;
	
	public ImageData(String path) {
		this.path = path;
		dataRef = new SoftReference<byte[]>(new byte[0]);
	}
	
	public String getPath() {
		return path;
	}
	
	private byte[] readImage() {
		return new byte[1024 * 1024];
	}
	
	public byte[] getData() {
		byte[] dataArray = dataRef.get();
        if (dataArray == null || dataArray.length == 0) {
        	dataArray = readImage();
        	dataRef = new SoftReference<byte[]>(dataArray);
        }
        return dataArray;
	}
}

public class SoftRef {
	public static void main(String[] args) {
		int num = 500;
		//softRef(num);
		strongRef(num);
	}
	
	private static void softRef(int num) {
		Map<String, ImageData> cache = new HashMap<String, ImageData>();
		for (int i = 0; i < num; i++) {
			ImageData imageData = new ImageData("image-" + i);
			imageData.getData();
			cache.put(imageData.getPath(), imageData);
		}
	}
	
	private static void strongRef(int num) {
		Map<String, StrongImageData> cache = new HashMap<String, StrongImageData>();
		for (int i = 0; i < num; i++) {
			StrongImageData imageData = new StrongImageData("image-" + i);
			imageData.getData();
			cache.put(imageData.getPath(), imageData);
		}
	}
	
}
