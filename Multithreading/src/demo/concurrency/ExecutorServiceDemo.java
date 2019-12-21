/** Executor service and newFixedThreadPool Demo
 *	Initiates and control the execution of the threads. Provides alternative to Thread class and Runnable interface 
 *
 *	Executor,ExecutorService,ScheduleExecutorService interfaces
 *	ThreadPoolExecutor,SCheduledThreadPoolExecutor and Executors classes
 *	Shutdown(), Execute() methods
 */

package demo.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread1 implements Runnable {
	String name;
	CountDownLatch cdl;

	public MyThread1(CountDownLatch cdl1, String string) {
		this.name = string;
		this.cdl = cdl1;
		new Thread(this);

	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + " : " + i);
			cdl.countDown();
		}
	}

}

public class ExecutorServiceDemo {

	public static void main(String[] args) {

		ExecutorService es = Executors.newFixedThreadPool(2);
		CountDownLatch cdl1 = new CountDownLatch(5);
		CountDownLatch cdl2 = new CountDownLatch(5);
		CountDownLatch cdl3 = new CountDownLatch(5);
		CountDownLatch cdl4 = new CountDownLatch(5);

		es.execute(new MyThread1(cdl1, "A"));
		es.execute(new MyThread1(cdl2, "B"));
		es.execute(new MyThread1(cdl3, "C"));
		es.execute(new MyThread1(cdl4, "D"));

		try {
			cdl1.await();
			cdl2.await();
			cdl3.await();
			cdl4.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
		es.shutdown();

	}

}
