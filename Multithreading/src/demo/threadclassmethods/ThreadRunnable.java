// Creating thread with implementing runnable interface

package demo.threadclassmethods;

class newThread1 implements Runnable {
	newThread1() {
		Thread t = new Thread(this, "NewThread");
		System.out.println("new thraead Started");
		t.start();
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("child thread " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("Exiting child thread");
	}
}

public class ThreadRunnable {

	public static void main(String[] args) {
		new newThread1();
		try {
			for (int i = 0; i < 5; i++) {

				System.out.println("In main thread " + i);
				Thread.sleep(500);

			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("Exiting main thread");

	}

}
