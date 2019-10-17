// Creating thread with thread class and Runnable interface 

package demo.threadclassmethods;

class ThreadWithThread extends Thread {
	public void run() {
		System.out.println("Thread is running : Thread Class");
	}
}

class ThreadWithRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread is running : Runnable");
	}
	
}

public class ThreadCreate {

	public static void main(String[] args) {
		ThreadWithThread t1 = new ThreadWithThread();
		t1.start();
		
		ThreadWithRunnable ob = new ThreadWithRunnable();
		Thread t2 = new Thread(ob);
		t2.start();
	}

}
