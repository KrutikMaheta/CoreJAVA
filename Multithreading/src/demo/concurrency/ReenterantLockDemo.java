package demo.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ConcurrencyLockExample implements Runnable {

	private Lock lock;

	public ConcurrencyLockExample() {
		this.lock = new ReentrantLock();
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			System.out.println("Trying lock");
			if (lock.tryLock(10, TimeUnit.SECONDS)) {
				System.out.println("lock acquired");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// release lock
			System.out.println("Releasing lock");
			lock.unlock();
		}

	}

}

public class ReenterantLockDemo {

	public static void main(String[] args) {
		new ConcurrencyLockExample();
	}

}
