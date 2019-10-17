package demo.synchronization;

class Table {

	public void call(int i) {
		synchronized (this) {
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

}

public class SyncPract2 {

	public static void main(String[] args) {
		final Table tObj = new Table();

		// Method 1 to create thread with annonymous class

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				tObj.call(5);
			}
		});

		// Method 2 to create thread with annonymous class

		Thread t2 = new Thread() {
			public void run() {
				tObj.call(100);
			}
		};

		t1.start();
		t2.start();
	}

}
