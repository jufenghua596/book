package com.java7book.chapter7.gc;


public class BackgroundTaskPolling {

	public void testLog() {
		new Thread(new BackupTaskRunnable()).start();
		consumeMemory();
		System.gc();
		consumeMemory();
		System.gc();
		try {
			Thread.sleep(10000);
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

	public static void main(String[] args) {
		BackgroundTaskPolling blp = new BackgroundTaskPolling();
		blp.testLog();
	}

}
