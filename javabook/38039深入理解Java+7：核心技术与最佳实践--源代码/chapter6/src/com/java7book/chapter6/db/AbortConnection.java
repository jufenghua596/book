package com.java7book.chapter6.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AbortConnection {
	public void abortConnection() throws SQLException {
		Connection connection = DriverManager
				.getConnection("jdbc:derby://localhost/java7book");
		ThreadPoolExecutor executor = new DebugExecutorService(2, 10, 60,
				TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		connection.abort(executor);
		executor.shutdown();
		try {
			executor.awaitTermination(5, TimeUnit.MINUTES);
			System.out.println(executor.getCompletedTaskCount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static class DebugExecutorService extends ThreadPoolExecutor {

		public DebugExecutorService(int corePoolSize, int maximumPoolSize,
				long keepAliveTime, TimeUnit unit,
				BlockingQueue<Runnable> workQueue) {
			super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		}

		public void beforeExecute(Thread t, Runnable r) {
			System.out.println("清理任务：" + r.getClass());
			super.beforeExecute(t, r);
		}
	}

	public static void main(String[] args) {
		AbortConnection ca = new AbortConnection();
		try {
			ca.abortConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
