package com.java7book.chapter6.lang;

import java.util.Date;

public class StaticCompare {
	
	private static class Order implements Comparable<Order> {
		private long updateTime;
		public Order() {
			updateTime = new Date().getTime();
		}
		public int compareTo(Order order) {
			return Long.compare(updateTime, order.updateTime);
		}
	}

	public void compare() {
		Order order1 = new Order();
		Order order2 = new Order();
		System.out.println(order1.compareTo(order2));
	}
	
	public static void main(String[] args) {
		StaticCompare sc = new StaticCompare();
		sc.compare();
	}

}
