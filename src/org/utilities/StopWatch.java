package org.utilities;

public final class StopWatch {

	private static long startTime;
	private static long endTime;

	public static void startTimer() {
		startTime = System.currentTimeMillis();
		endTime = 0;
	}

	public static void endTimer() {
		endTime = System.currentTimeMillis();
		System.out.println(":: Executed in Time: " + (endTime - startTime) + "ms.");
	}
}
