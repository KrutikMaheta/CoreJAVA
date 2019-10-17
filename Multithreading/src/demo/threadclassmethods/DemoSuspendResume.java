package demo.threadclassmethods;

class NewThreadCreate implements Runnable {
	Thread t;
	String name;
	boolean canSuspend;

	public NewThreadCreate(String name) {
		this.name = name;
		canSuspend = false;
		t = new Thread(this,name);
		System.out.println("New thread created : " + t);
		t.start();
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 15; i++) {
				System.out.println(name + " : " + i);
				Thread.sleep(200);
				synchronized (this) {
					while (canSuspend)
						wait();
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Execution interrupted");
		}
	}

	void suspend() {
		canSuspend = true;
	}

	void resume() {
		canSuspend = false;
		notify();
	}

}

public class DemoSuspendResume {

	public static void main(String[] args) {
		NewThreadCreate ob1 = new NewThreadCreate("One");
		NewThreadCreate ob2 = new NewThreadCreate("Two");
		
		try{
			
			Thread.sleep(1000);
			ob1.suspend();
			System.out.println("Thread one is suspending");
			Thread.sleep(1000);
			ob1.resume();
			System.out.println("Thread two is resuming");
			
			
			ob2.suspend();
			Thread.sleep(1000);
			System.out.println("Thread one is suspending");
			ob2.resume();
			System.out.println("Thread two is resuming");
			
			
			
		}
		catch(InterruptedException e){
			System.out.println("Thread abpted");
		}
		
		try{
			ob1.t.join();
			ob2.t.join();
		}
		catch(InterruptedException e){
			System.out.println("Thread abpted");
		}
	}

}
