package demo.deadlock;

public class DemoDeadLock_2 {

	public static void main(String[] args) {
		final String rsc1 = "Krutik Maheta";
		final String rsc2 = "Bill gates";

		Thread t1 = new Thread() {

			public void run() {
				synchronized (rsc1) {
					System.out.println("Lock on resource 1 by : " + getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (rsc2) {
						System.out.println("Lock on resource 2 by : " + getName());
					}
				}
			}
		};

		t1.setName("Thread 1");

		Thread t2 = new Thread() {
			public void run() {
				synchronized (rsc2) {
					System.out.println("lock  on resource 2 by  : " + getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (rsc1) {
						System.out.println("lock  on rsc1 by  : " + getName());
					}
				}
			}
		};

		t2.setName("Thread 2");

		t1.start();
		t2.start();

	}

}
