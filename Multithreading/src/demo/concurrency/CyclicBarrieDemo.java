// CycliBarrier Demo
/**
 *  Used in the case when two or more threads must wait at a predefined execution point until 
 *  all threads in the set have reached at that point.
 *	As in the following example we can reuse the cyclicbarrier
 *  
 *  CyclieBarrier(int numOfThreads)
 *  CyclieBarrier(int numOfThreads,Runnable action)
 *
 */
 

package demo.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class BarAction implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Barrier Reached");
	}

}

class MyThread2 implements Runnable {
	CyclicBarrier cb;
	String name;

	public MyThread2(CyclicBarrier cb2, String string) {
		// TODO Auto-generated constructor stub
		cb = cb2;
		name = string;
		new Thread(this).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name);
		try {
			cb.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class CyclicBarrieDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
		System.out.println("Starting");
		new MyThread2(cb, "A");
		new MyThread2(cb, "B");
		new MyThread2(cb, "C");

		new MyThread2(cb, "P");
		new MyThread2(cb, "Q");
		new MyThread2(cb, "R");

	}

}
