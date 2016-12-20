package com.csu.bio.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUtil {
	public final ExecutorService executorService = Executors
			.newCachedThreadPool();
	public static ThreadPoolUtil instance;

	public void init() {
		instance = this;
	}

	public void destory() {
		instance.executorService.shutdownNow();
	}

	public static void addRunnable(Runnable command) {
		instance.executorService.execute(command);
	}
}
