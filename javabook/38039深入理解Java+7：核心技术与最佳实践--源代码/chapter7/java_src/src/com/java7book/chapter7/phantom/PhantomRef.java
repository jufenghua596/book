package com.java7book.chapter7.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomRef {
	
	static class PhantomObject {
		public String toString() {
			return "Phantom";
		}
	}

	public static void main(String[] args) {
		 ReferenceQueue queue = new ReferenceQueue(); 
		 PhantomObject obj = new PhantomObject();
		 PhantomReference ref = new PhantomReference(obj, queue);
		 obj = null;
		 System.gc();
		 
		 try {
			Reference r = queue.remove();
			if (r instanceof PhantomReference) {
				PhantomReference pr = (PhantomReference) r;
				pr.clear();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
