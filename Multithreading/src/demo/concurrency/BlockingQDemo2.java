package demo.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Producer2 using BlockingQueue example
 * @author www.codejava.net
 *
 */
class Producer2 implements Runnable {
    private BlockingQueue<Integer> queue;
 
    public Producer2 (BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
 
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                queue.put(produce());
 
                Thread.sleep(500);
            }
 
            queue.put(-1);  // indicates end of producing
 
            System.out.println("Producer2 STOPPED.");
 
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
 
    private Integer produce() {
        Integer number = new Integer((int) (Math.random() * 100));
 
 
        System.out.println("Producing number => " + number);
 
        return number;
    }
}

class Consumer2 implements Runnable {
	private BlockingQueue<Integer> queue;
	private String threadId;

	public Consumer2(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		threadId = "Consumer2-" + Thread.currentThread().getId();
		try {

			while (true) {
				Integer number = queue.poll(5, TimeUnit.SECONDS);

				if (number == null || number == -1) {
					break;
				}

				consume(number);

				Thread.sleep(1000);
			}

			System.out.println(threadId + " STOPPED.");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	private void consume(Integer number) {

		System.out.println(threadId + ": Consuming number <= " + number);

	}
}

public class BlockingQDemo2 {

	public static void main(String[] args) {

		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20);

		Thread Producer2 = new Thread(new Producer2(queue));

		Thread consumer1 = new Thread(new Consumer2(queue));
		Thread consumer2 = new Thread(new Consumer2(queue));
		Thread consumer3 = new Thread(new Consumer2(queue));

		Producer2.start();

		consumer1.start();
		consumer2.start();
		consumer3.start();

	}

}
