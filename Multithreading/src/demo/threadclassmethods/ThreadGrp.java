//Thread Grp demo and its method's demo


package demo.threadclassmethods;

class NewThread extends Thread {
	boolean suspendflag;

	public NewThread(String threadName, ThreadGroup tgob) {

		super(tgob, threadName);
		System.out.println("New Thread : " + this);
		suspendflag = false;
		start();
	}

	public void run() {
		try {
			for (int i = 5; i >= 0; i--) {
				System.out.println(getName() + ": " + i);
				sleep(1000);
				synchronized (this) {
					while (suspendflag)
						wait();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in " + getName());
		}

		System.out.println(getName() + " Exits");
	}

	public void mysuspend() {
		suspendflag = true;
	}

	synchronized void myresume() {
		suspendflag = false;
		notify();
	}
}

public class ThreadGrp {

	public static void main(String[] args) {
		ThreadGroup grpA = new ThreadGroup("Group A");
		ThreadGroup grpB = new ThreadGroup("Group B");
		NewThread ob1 = new NewThread("One", grpA);
		NewThread ob2 = new NewThread("Two", grpA);
		NewThread ob3 = new NewThread("Three", grpB);
		NewThread ob4 = new NewThread("Four", grpB);

		grpA.list();
		grpB.list();
		System.out.println();

		System.out.println("Suspending Grp A for 4 secs");

		Thread[] tga = new Thread[grpA.activeCount()];
		grpA.enumerate(tga);

		for (Thread thread : tga) {
			((NewThread) thread).mysuspend();
		}

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Resuming Grp A");
		for (Thread thread : tga) {
			((NewThread) thread).myresume();
		}

		try {
			System.out.println("Waiting for all thread to finish");
			ob1.join();
			ob2.join();
			ob3.join();
			ob4.join();

		} catch (Exception e) {
			System.out.println("Exception in main thread");
		}

		System.out.println("main thread exiting");
	}

}
