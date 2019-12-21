package demo.concurrency;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo2 implements Callable<String> {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		ArrayList<Future<String>> futList = new ArrayList<Future<String>>();
		Callable<String> callable = new CallableDemo2();

		for (int i = 0; i < 100; i++) {
			futList.add(executor.submit(callable));
		}

		for (Future<String> future : futList) {
			System.out.println(new Date() +"::"+ future.get());
		}
		executor.shutdown();
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return Thread.currentThread().getName();
	}

}
