/**
 * More advanced example
 */

package demo.concurrency;

import java.util.concurrent.CountDownLatch;

class UIInitialization implements Runnable {

	CountDownLatch latch;

	UIInitialization(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Initializing UI");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done with UI Initialization");
		latch.countDown();
	}

}

class LoggingInitialization implements Runnable {

	CountDownLatch latch;

	LoggingInitialization(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Initializing Logging");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done with Logging Initialization");
		latch.countDown();
	}

}

class DatabaseInitialization implements Runnable {

	CountDownLatch latch;

	DatabaseInitialization(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Initializing Database");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done with database Initialization");
		latch.countDown();
	}

}

public class CountDownLatchPractical1 {

	public static void main(String[] args) {
		try {
			CountDownLatch latch = new CountDownLatch(3);

			// Initializing three dependent thread i.e. UI, database and logging

			UIInitialization uiInitialization = new UIInitialization(latch);
			Thread uiThread = new Thread(uiInitialization);

			DatabaseInitialization dataBaseInitialization = new DatabaseInitialization(latch);
			Thread databaseThread = new Thread(dataBaseInitialization);

			LoggingInitialization loggingInitialization = new LoggingInitialization(latch);
			Thread loggingThread = new Thread(loggingInitialization);

			uiThread.start();
			databaseThread.start();
			loggingThread.start();
			// Main thread will wait until above threads get completed
			latch.await();

			System.out.println("Initialization has been completed, main thread can proceed now");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
