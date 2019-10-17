package demo.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable {

	String message;

	public WorkerThread(String s) {
		message = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " (start) message = " + message);
		processmessage();
		System.out.println(Thread.currentThread().getName() + " end");
	}

	private void processmessage() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class ThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("All finished");

	}
}
