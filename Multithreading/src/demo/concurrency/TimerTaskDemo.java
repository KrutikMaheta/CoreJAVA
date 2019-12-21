/** TimerTask and Time
 * The output confirms that if a task is already executing, 
 * Timer will wait for it to finish and once finished, it will start again the next task from the queue.
 */

package demo.concurrency;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskDemo extends TimerTask {

	public static void main(String[] args) throws InterruptedException {
		TimerTask tObj = new TimerTaskDemo();
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(tObj, 0, 4 * 1000);
		System.out.println("Timer started");
		Thread.sleep(80000);
		timer.cancel();
		System.out.println("Time cancelled : "+ new Date());
		Thread.sleep(10000);
	}

	@Override	
	public void run() {
		System.out.println("Time task started at : " + new Date());
		complete();
		System.out.println("Time task ended at : " + new Date());
	}

	private void complete() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
