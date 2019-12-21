// Semaphore Demo
/**
 * It implements a classic semaphore.It controls a access to the shared resource through the use of counter.
 * What this counter counts is permits that allow access to shared resource.
 * So to access the shared resource thread must be granted a permission from the semaphore.
 * 
 * acquire() and release() methods
 * 
 */

package demo.concurrency;

import java.util.concurrent.Semaphore;

class Q {

	int n;

	Semaphore semCon = new Semaphore(0);
	Semaphore semProd = new Semaphore(1);

	public void get() throws InterruptedException {
		semCon.acquire();
		System.out.println("Got : " + n);
		semProd.release();
	}

	public void put(int n) throws InterruptedException {
		semProd.acquire();
		System.out.println("Put : " + n);
		this.n = n;
		semCon.release();
	}
}

class Consumer3 implements Runnable {
	Q q;

	Consumer3(Q q) {
		this.q = q;
		new Thread(this, "Cons").start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
			try {
				q.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

}

class Producer3 implements Runnable {

	Q q;

	public Producer3(Q q) {
		this.q = q;
		new Thread(this, "Prod").start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				q.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class SemaphoreDemo {

	public static void main(String[] args) {
		Q q = new Q();
		new Producer3(q);
		new Consumer3(q);
	}
}
