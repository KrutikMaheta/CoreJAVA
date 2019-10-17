// Use of synchronized keyword and synchronized block

package demo.synchronization;

class CallMe {

// Using synchronized before method will allow only one object to access it at a time
	
	/*synchronized public void call(String msg) {
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted");
		}
		System.out.println("]");
	}*/
	
	// Another way
	
	public void call(String msg) {
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted");
		}
		System.out.println("]");
	}
}

class Caller implements Runnable {
	Thread t;
	String msg;
	CallMe obj;

	Caller(CallMe obj, String msg) {
		t = new Thread(this);
		this.obj = obj;
		this.msg = msg;
		t.start();
	}

	@Override
	public void run() {
		
		//obj.call(msg);
		
	// another Way : This will cause the thread to wait for the prior one to finish before proceeding
		synchronized (obj) {
			obj.call(msg);	
		}
	}
}

public class ThreadSync {

	public static void main(String[] args) {
		CallMe cobj = new CallMe();

		Caller c1 = new Caller(cobj, "Hello");
		Caller c2 = new Caller(cobj, "sync");
		Caller c3 = new Caller(cobj, "world");

		try {
			c1.t.join();
			c2.t.join();
			c3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Thread terminated");
		}
	}

}
