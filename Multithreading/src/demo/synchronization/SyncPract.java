package demo.synchronization;

class Class1 {

	synchronized public void display(String string) {
		System.out.print("[ " + string);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print(" ]");
	}

}

class Class2 extends Thread {

	Class1 cObj;
	String string;

	public Class2(Class1 cObj, String string) {
		this.cObj = cObj;
		this.string = string;
	}

	@Override
	public void run() {
		cObj.display(string);

	}

}

public class SyncPract {

	public static void main(String[] args) throws InterruptedException {

		Class1 cObj = new Class1();
		Class2 c1 = new Class2(cObj, "Hi");
		Class2 c2 = new Class2(cObj, "Krutik");
		Class2 c3 = new Class2(cObj, "Mehta");

		c1.start();
		c2.start();
		c3.start();

		c1.join();
		c2.join();
		c3.join();

		System.out.println("\nMain exits");

	}

}
