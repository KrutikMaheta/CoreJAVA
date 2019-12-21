package demo.synchronization;

import java.sql.Time;

class Message {
	String msg;

	public Message(String msg) {
		this.msg = msg;
	}

	public String getStr() {
		return msg;
	}

	public void setStr(String msg) {
		this.msg = msg;
	}
}

class Waiter implements Runnable {

	Message msg;

	Waiter(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		System.out.println("Thread: " + Thread.currentThread().getName() + "Started");
		synchronized (msg) {
			System.out.println(Thread.currentThread().getName() + " waiting to get access at "
					+ new Time(System.currentTimeMillis()));
			try {
				msg.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(
				Thread.currentThread().getName() + " got the access at " + new Time(System.currentTimeMillis()));
		System.out.println(Thread.currentThread().getName() + ": " + msg.getStr());
	}

}

class Notifier implements Runnable {

	Message msg;

	Notifier(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		System.out.println("Thread: " + Thread.currentThread().getName() + "Started");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (msg) {
			System.out.println(Thread.currentThread().getName() + " has access");
			msg.setStr("Krutik");
			System.out.println(
					Thread.currentThread().getName() + " gave the access at" + new Time(System.currentTimeMillis()));
			msg.notifyAll();

			// msg.notify();
		}
	}

}

public class WaitNotifyDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Message msg = new Message("Process it");
		Waiter waiter1 = new Waiter(msg);
		Waiter waiter2 = new Waiter(msg);
		Notifier notifier = new Notifier(msg);

		new Thread(waiter1, "waiter1").start();
		new Thread(waiter2, "waiter2").start();
		new Thread(notifier, "notifier").start();

	}

}
