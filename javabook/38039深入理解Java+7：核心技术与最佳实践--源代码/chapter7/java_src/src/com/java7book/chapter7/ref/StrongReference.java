package com.java7book.chapter7.ref;

public class StrongReference {

	private static ReferencedObject refObject = new ReferencedObject();

	public void test() {
		SecondaryObject obj= refObject.getSecondaryObject();
		int count = obj.count();
		
	}

}
