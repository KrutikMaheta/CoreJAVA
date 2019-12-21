package demo.concurrency;

import java.util.concurrent.Semaphore;

class Shared {
	static int count = 0;
}

class IncThread implements Runnable {

	Semaphore sem;
	String name;

	public IncThread(String string, Semaphore sem) {
		this.sem = sem;
		this.name = string;
		new Thread(this).start();
	}

	@Override
	public void run() {

		try {
			//System.out.println(name + " is waiting for the access");
			sem.acquire();
			//System.out.println(name + " got the access");

			for (int i = 0; i < 5; i++) {
				Shared.count++;
				System.out.println(name + ": " + Shared.count);
				Thread.sleep(10);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//System.out.println(name + " is releasing access");
		sem.release();
	}

}

class DecThread implements Runnable {
	Semaphore sem;
	String name;

	public DecThread(String string, Semaphore sem) {
		this.sem = sem;
		this.name = string;
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {

			//System.out.println(name + " is waiting for the access");
			sem.acquire();
			//System.out.println(name + " got the access");

			for (int i = 0; i < 5; i++) {
				Shared.count--;
				System.out.println(name + ": " + Shared.count);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//System.out.println(name + " is releasing access");
		sem.release();

	}

}

public class SemaPhoreDemo2 {

	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		new IncThread("A", sem);
		new DecThread("B", sem);
	}

}
