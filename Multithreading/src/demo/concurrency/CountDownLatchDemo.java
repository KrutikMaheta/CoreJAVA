/** 
 * CountDownLatch
 * 
 * To handle situation when thread is required to wait for one or more events occurred.
 * CountDownLatch is created with a count of number of events that must occur before the latch is
 * released.Each time an event happens, the count is decremented.
 * When the counter reaches 0 the latch opens.
 * 
 * Await() and CountDown() methods
 * 
 */

package demo.concurrency;

import java.util.concurrent.CountDownLatch;

class MyThread implements Runnable{
	CountDownLatch cdl;
	
	MyThread(CountDownLatch cdl){
		this.cdl = cdl;
		new Thread(this).start();
	}

	@Override
	public void run() {
		System.out.println("Starting");
		for(int i=5 ; i>0 ;i--){
			cdl.countDown();
			System.out.println("Countdown : "+i);
		}
			
	}
}

public class CountDownLatchDemo {

	public static void main(String[] args) {

		CountDownLatch cdl = new CountDownLatch(5);
		new MyThread(cdl);
		
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("done");
	}

}
