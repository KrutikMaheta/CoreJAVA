package demo.threadclassmethods;

class DeamonThread implements Runnable {

	@Override
	public void run() {
		while (true)
			try {
				processSome();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

	private void processSome() throws InterruptedException {
		System.out.println("In deamon thread");
		Thread.sleep(5000);
	}

}

public class DeamonThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread it = new Thread(new DeamonThread(), "dt");
		it.setDaemon(true);
		it.start();

		Thread.sleep(2000);
		System.out.println("Main Exists");
	}

}
