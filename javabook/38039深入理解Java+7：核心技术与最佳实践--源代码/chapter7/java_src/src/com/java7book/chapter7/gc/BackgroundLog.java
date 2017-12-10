package com.java7book.chapter7.gc;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryNotificationInfo;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;

public class BackgroundLog {

	private volatile static boolean lowMemory = false;

	private static class MemoryListener implements NotificationListener {

		public void handleNotification(Notification notification,
				Object handback) {
			String type = notification.getType();
			if (type
					.equals(MemoryNotificationInfo.MEMORY_THRESHOLD_EXCEEDED)) {
				System.out.println("内存占用量超过阈值。");
			}
		}
	}

	private static class LogRunnable implements Runnable {
		@Override
		public void run() {
			while (!lowMemory) {
				System.out.println("Log");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("NOT LOG");
		}
	}

	public void log() {
		new Thread(new LogRunnable()).start();
		
		
		List<MemoryPoolMXBean> beans = ManagementFactory.getMemoryPoolMXBeans();
		MemoryPoolMXBean pool = null;
		for (MemoryPoolMXBean bean : beans) {
			if ("Tenured Gen".equals(bean.getName())) {
				pool = bean;
				break;
			}
		}
		
		MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
		NotificationEmitter emitter = (NotificationEmitter) mbean;
		MemoryListener listener = new MemoryListener();
		emitter.addNotificationListener(listener, null, null);
		pool.setUsageThreshold(8 * 1024 * 1024);
		
		consumeMemory();
		System.gc();
		checkMemory(pool);
		consumeMemory();
		checkMemory(pool);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void consumeMemory() {
		byte[] data1 = new byte[12 * 1024 * 1024];
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		byte[] data2 = new byte[12 * 1024 * 1024];
	}
	
	private void checkMemory(MemoryPoolMXBean bean) {
		lowMemory = bean.isUsageThresholdExceeded();
	}

	public static void main(String[] args) {
		BackgroundLog log = new BackgroundLog();
		log.log();
	}

}
