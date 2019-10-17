package demo.synchronization;

class PrintTable {

	synchronized static public void call(int i) {

		for (int n = 1; n < 5; n++) {
			System.out.println(i * n);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class StaticSyncMethod {

	public static void main(String[] args) {
		final Table tObj = new Table();

		// Method 1 to create thread with annonymous class

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				tObj.call(1);
			}
		});

		// Method 2 to create thread with annonymous class

		Thread t2 = new Thread() {
			public void run() {
				tObj.call(10);
			}
		};

		Thread t3 = new Thread() {
			public void run() {
				tObj.call(100);
			}
		};

		Thread t4 = new Thread() {
			public void run() {
				tObj.call(1000);
			}
		};

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
