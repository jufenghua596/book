package com.java7book.chapter7.gc;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

public class BackupTaskRunnable implements Runnable {

	private MemoryPoolMXBean poolBean;

	public BackupTaskRunnable() {
		init();
	}

	private void init() {
		List<MemoryPoolMXBean> beans = ManagementFactory
				.getMemoryPoolMXBeans();
		for (MemoryPoolMXBean bean : beans) {
			if ("Tenured Gen".equals(bean.getName())) {
				poolBean = bean;
				break;
			}
		}
		poolBean.setUsageThreshold(10 * 1024 * 1024);
	}

	public void run() {
		while (true) {
			if (poolBean.isUsageThresholdExceeded()) {
				System.out.println("内存不足，暂停备份任务。");
			} else {
				System.out.println("执行备份任务。");
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}