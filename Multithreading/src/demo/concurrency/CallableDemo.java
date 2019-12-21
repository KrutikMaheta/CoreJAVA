/**	
 * 
 * Use of callable and future interface
 * 	Callable interface represents a thread which returns a value as Future Object
 * 	Can also be used to design a thread that returns the status code that indicates the successful 
 * 	completion of thread. 
 * 	
 * 
 * 	Callable method : call() used to define the task that you want to perform.
 * 	Callable task is excuted by the submit() method of ExecutorService
 *  Callable and Future interfaces
 *  
 *  <T> Future<T> submit(Callable<T> task)
 *  V get()
 *  
 */

package demo.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Sum implements Callable<Integer> {

	int stop;

	public Sum(int i) {
		stop = i;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i < stop; i++)
			sum += i;
		return sum;
	}

}

class Area implements Callable<Double> {

	int a, b;

	public Area(int i, int j) {
		a = i;
		b = j;
	}

	@Override
	public Double call() throws Exception {
		return Math.sqrt((a * a) + (b * b));
	}

}

class Fact implements Callable<Integer> {

	int stop;

	public Fact(int i) {
		stop = i;
	}

	@Override
	public Integer call() throws Exception {
		int res = 1;
		for (int i = 2; i <= stop; i++)
			res *= i;
		return res;
	}

}

public class CallableDemo {

	public static void main(String[] args) {

		ExecutorService es = Executors.newFixedThreadPool(3);
		Future<Integer> f1;
		Future<Double> f2;
		Future<Integer> f3;

		f1 = es.submit(new Sum(10));
		f2 = es.submit(new Area(3, 4));
		f3 = es.submit(new Fact(5));

		try {
			System.out.println(f1.get());
			System.out.println(f2.get());
			System.out.println(f3.get());

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		es.shutdown();
		System.out.println("Done");

	}

}
