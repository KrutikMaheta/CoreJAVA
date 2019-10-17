package demo.deadlock;

public class DemoDeadLock_3 {

	static Object rsc1 = new Object();
	static Object rsc2 = new Object();

	public static void main(String[] args) {
		ThreadDemo1 t1 = new ThreadDemo1();
		ThreadDemo2 t2 = new ThreadDemo2();
		t1.start();
		t2.start();
	}

	static class ThreadDemo1 extends Thread {
		public void run() {
			synchronized (rsc1) {
				System.out.println("Thread 1 acquire lock on rsc1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread 1 waiting for rsc2");
				synchronized (rsc2) {
					System.out.println("Thread 1 acquire rsc1 and rsc2");
				}
			}
		}
	}

	/**
	 * Code Without Deadlock
	 */
	
	/*static class ThreadDemo2 extends Thread {
		public void run() {
			synchronized (rsc1) {
				System.out.println("Thread 2 acquire lock on rsc1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread 2 waiting for rsc2");
				synchronized (rsc2) {
					System.out.println("Thread 2 acquire rsc1 and rsc2");
				}
			}
		}
	}*/
	
	/** 
	 * Code With deadlock
	 * @author Krutik
	 *
	 */
	
	static class ThreadDemo2 extends Thread {
		public void run() {
			synchronized (rsc2) {
				System.out.println("Thread 2 acquire lock on rsc2");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 2 waiting for rsc1");
				synchronized (rsc1) {
					System.out.println("Thread 2 acquire rsc1 and rsc2");
				}
			}
		}
	}

}
