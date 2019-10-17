package demo.synchronization;

class Queue {
	int n;
	boolean valueSet = false;

	synchronized int get() {
		while (!valueSet) {
			try {
				//System.out.println("get wait");
				wait();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		valueSet = false;
		//System.out.println("get notify");
		notify();
		System.out.println("get " + n);
		return n;
	}

	synchronized void put(int n) {
		while (valueSet) {
			try {
				//System.out.println("put wait");
				wait();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		valueSet = true;
		//System.out.println("put notify");
		notify();
		this.n = n;
		System.out.println("put " + n);
	}
}

class Producer implements Runnable {

	Thread t;
	Queue q;

	public Producer(Queue q) {
		// TODO Auto-generated constructor stub
		t = new Thread(this, "Producer");
		t.start();
		this.q = q;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while (true) {
			q.put(i++);
			if(i == 10)
				break;
		}
	}

}

class Consumer implements Runnable {

	Thread t;
	Queue q;

	public Consumer(Queue q) {
		// TODO Auto-generated constructor stub
		t = new Thread(this, "Producer");
		t.start();
		this.q = q;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true)
			q.get();
	}

}

public class WaitNotifyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		new Producer(q);
		new Consumer(q);
	}

}
