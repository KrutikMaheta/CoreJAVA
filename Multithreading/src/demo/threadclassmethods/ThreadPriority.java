package demo.threadclassmethods;

class clicker implements Runnable {
	int click = 0;
	Thread t;
	private static boolean running = true;

	public clicker(int n) {
		t = new Thread(this);
		t.setPriority(n);
	}

	public void stop() {
		running = false;
	}

	@Override
	public void run() {
		while (running)
			click++;
	}

	public void start() {
		t.start();
	}
}

public class ThreadPriority {

	public static void main(String[] args) {
		
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		clicker hp = new clicker(Thread.NORM_PRIORITY + 2);
		clicker lp = new clicker(Thread.NORM_PRIORITY - 2);

		hp.start();
		lp.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		hp.stop();
		lp.stop();

		try {
			hp.t.join();
			lp.t.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		System.out.println("Low priority Thread Clicks = " + lp.click);
		System.out.println("high priority Thread Clicks = " + hp.click);

	}
}