// Stopping thread with timer task

package demo.threadclassmethods;

import java.util.Timer;
import java.util.TimerTask;

class StoppingThread extends Thread {
	boolean stop = false;
	int count = 0;

	public void run() {
		while (!stop && count != 100000) {
			System.out.println(count++);
		}
		if (stop) {
			System.out.println("stop detected");
		}
	}
}

public class ThreadStop {

	public static void main(String[] args) {
		final StoppingThread st = new StoppingThread();
		st.start();
		
		new Timer(true).schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("Requesting Stop");
				st.stop = true;
			}
		}, 1000);
	}

}
