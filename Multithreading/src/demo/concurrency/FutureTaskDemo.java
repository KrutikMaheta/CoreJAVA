package demo.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class CallableImpl implements Callable<String> {

	int milSecs;

	CallableImpl(int milSecs) {
		this.milSecs = milSecs;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(milSecs);
		return Thread.currentThread().getName();
	}

}

public class FutureTaskDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
		CallableImpl cl1 = new CallableImpl(2000);
		CallableImpl cl2 = new CallableImpl(3000);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		FutureTask<String> ft1 = new FutureTask<>(cl1);
		FutureTask<String> ft2 = new FutureTask<>(cl2);

		executor.execute(ft1);
		executor.execute(ft2);

		while (true) {
			if (ft1.isDone() && ft2.isDone()) {
				System.out.println("Tasks done");
				executor.shutdown();
				return;
			}
			if (!ft1.isDone()) {
				System.out.println("Future task1 OP : " + ft1.get());
			}
			try {
				System.out.println("waiting for task 2 to complete");
				String s = ft2.get(200, TimeUnit.MILLISECONDS);
				if (s != null) {
					System.out.println("Task 2 op : " + ft2.get());
				}
			} catch (TimeoutException e) {
				//System.out.println("Timeout exceptio");
			}

		}
	}

}
