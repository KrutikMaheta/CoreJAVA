// Creating thread with implementing runnable interface

package demo.threadclassmethods;

class newThread2 extends Thread {
	newThread2() {
		super("NewThread");
		System.out.println("new thraead Started");
		start();
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

public class ThreadClass {

	public static void main(String[] args) {
		new newThread2();
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