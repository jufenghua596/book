package com.java7book.chapter7.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class UseReferenceQueue {

	private static class ReferencedObject {
		protected void finalize() throws Throwable {
			System.out.println("finalize方法被调用。" );
			super.finalize();
		}
	}

	public void softReferenceQueue() {
		ReferenceQueue<ReferencedObject> queue = new ReferenceQueue<>();
		ReferencedObject obj = new ReferencedObject();
		SoftReference<ReferencedObject> softRef = new SoftReference<ReferencedObject>(obj,
				queue);
		obj = null;
		Reference<? extends ReferencedObject> ref = null;
		while ((ref = queue.poll()) == null) {
			System.gc();
		}
		System.out.println("软引用进入队列：");
	}
	
	public void weakReferenceQueue() {
		ReferenceQueue<ReferencedObject> queue = new ReferenceQueue<>();
		ReferencedObject obj1 = new ReferencedObject();
		WeakReference<ReferencedObject> softRef = new WeakReference<ReferencedObject>(obj1,
				queue);
		obj1 = null;
		Reference<? extends ReferencedObject> ref = null;
		while ((ref = queue.poll()) == null) {
			System.gc();
		}
		System.out.println("WEAK");
	}

	public void phantomReferenceQueue() {
		ReferenceQueue<ReferencedObject> queue = new ReferenceQueue<>();
		ReferencedObject obj = new ReferencedObject();
		PhantomReference<ReferencedObject> phantomRef = new PhantomReference<ReferencedObject>(
				obj, queue);
		obj = null;
		Reference<? extends ReferencedObject> ref = null;
		while ((ref = queue.poll()) == null) {
			System.gc();
		}
		phantomRef.clear();
		System.out.println(ref == phantomRef);
		System.out.println("幽灵引用被清除。");
	}

	public static void main(String[] args) {
		UseReferenceQueue urq = new UseReferenceQueue();
		//urq.softReferenceQueue();
		//urq.weakReferenceQueue();
		urq.phantomReferenceQueue();
	}

}
