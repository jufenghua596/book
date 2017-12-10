package com.java7book.chapter7.ref;

import java.util.ArrayList;
import java.util.List;

public class LeakingQueue<T> {
	private List<T> backendList = new ArrayList<T>();
	
	private int topIndex = 0;
	
	public void enqueue(T value){
		backendList.add(value);
	}
	
	public T dequeue() {
		T result = backendList.get(topIndex);
		topIndex++;
		return result;
	}
	
	public static void main(String[] args) {
		LeakingQueue<String> stack = new LeakingQueue<String>();
		stack.enqueue("Hello");
		stack.enqueue("World");
		stack.dequeue();
		stack.enqueue("Goodbye");
		String value = stack.dequeue();
		System.out.println(value);
	}
}
