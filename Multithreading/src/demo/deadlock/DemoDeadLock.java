package demo.deadlock;

class A {
	synchronized public void foo(B b) {
		String name;
		name = Thread.currentThread().getName();
		System.out.println("Thread: " + name + "entered foo() method");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("Thread : " + name + "trying to call last() method in b");
		b.last();
	}

	synchronized public void last() { 
		System.out.println("Inside A class last mthod");
	}
}

class B {
	synchronized public void bar(A a) {
		String name;
		name = Thread.currentThread().getName();
		System.out.println("Thread: " + name + " entered bar() method");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("Thread : " + name + " trying to call last() method in b");
		a.last();
	}

	synchronized public void last() {
		System.out.println(" Inside B class last mthod");
	}
}

public class DemoDeadLock implements Runnable {

	Thread t;
	A a = new A();
	B b = new B();

	public DemoDeadLock() {
		Thread.currentThread().setName("MainThread");
		t = new Thread(this, "DeadLock");
		t.start();
		a.foo(b);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		b.bar(a);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DemoDeadLock();
	}

}
