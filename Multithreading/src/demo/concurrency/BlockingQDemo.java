package demo.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class MessagePass {
	String msg;

	public MessagePass(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}

class Producer implements Runnable {
	BlockingQueue<MessagePass> bq;

	Producer(BlockingQueue<MessagePass> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {

		for (int i = 0; i < 100; i++) {
			MessagePass msg = new MessagePass("msg : " + i);

			try {
				Thread.sleep(i);
				bq.put(msg);
				System.out.println(Thread.currentThread().getName() + " put message: " + msg.getMsg());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			msg = new MessagePass("exit");
			try {
				bq.put(msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

class Consumer implements Runnable {

	BlockingQueue<MessagePass> bq;

	public Consumer(BlockingQueue<MessagePass> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		try {
			MessagePass msg;
			while (!((msg = bq.take()).getMsg()).equals("exit")) {
				Thread.sleep(10);
				System.out.println(Thread.currentThread().getName() + " Consumes " + msg.getMsg());

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class BlockingQDemo {

	public static void main(String[] args) {
		
		BlockingQueue<MessagePass> bq = new ArrayBlockingQueue<MessagePass>(10);
		Producer p = new Producer(bq);
		Consumer c = new Consumer(bq);

		new Thread(p, "Producer").start();
		new Thread(c, "Consumer").start();

	}

}
