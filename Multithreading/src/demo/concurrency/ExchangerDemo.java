/** Exchanger Demo
*   It is designed to simplify exchange of data between two threads
*	It simply waits until two separate threads calls its exchange method
*	When occurs it simply exchanges the data between two threads
*	Point : It wont succeed until it is being called on the same Exchanger object by two separate threads
*	
*	V exchange(V buffer);
*
*/

// 

package demo.concurrency;

import java.util.concurrent.Exchanger;

class MakeString implements Runnable {
	Exchanger<String> exc;
	String s;

	public MakeString(Exchanger<String> exc) {
		this.exc = exc;
		s = new String();
		new Thread(this).start();
	}

	@Override
	public void run() {
		char ch = 'A';
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++)
				s += ch++;
			try {
				s = exc.exchange(s);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

class UseString implements Runnable {

	Exchanger<String> exc;
	String s;

	public UseString(Exchanger<String> exc) {
		this.exc = exc;
		new Thread(this).start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				s = exc.exchange(new String());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Got: " + s);
		}

	}

}

public class ExchangerDemo {

	public static void main(String[] args) {

		Exchanger<String> exc = new Exchanger<String>();
		new MakeString(exc);
		new UseString(exc);

	}

}
