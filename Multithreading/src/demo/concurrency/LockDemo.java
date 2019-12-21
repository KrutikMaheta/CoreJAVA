// ReentrantLock() Demo
// Can be used as a replacement over synchronized method for controling access over shared resource

package demo.concurrency;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
	static int count = 0;
}

class LockThread implements Runnable {

	String name;
	ReentrantLock lock;

	public LockThread(ReentrantLock lock, String string) {
		this.lock = lock;
		name = string;
		new Thread(this).start();
	}

	@Override
	public void run() {
		System.out.println(name + " is starting");
		System.out.println(name + " is waiting to acquire lock");
		lock.lock();
		System.out.println(name + " has acquired the lock");
		SharedResource.count++;
		System.out.println(name + " : " + SharedResource.count);
		System.out.println("Context switch");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(name + " is releasing the lock");
			lock.unlock();
		}

	}

}

public class LockDemo {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		new LockThread(lock, "A");
		new LockThread(lock, "B");

	}
}
