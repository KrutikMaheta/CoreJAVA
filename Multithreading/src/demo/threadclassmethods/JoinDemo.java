// Use of join and isAlive() method

package demo.threadclassmethods;

class ThreadSample implements Runnable {
	String name;
	Thread t;

	public ThreadSample(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		t = new Thread(this, name);
		System.out.println("New thread : "+t);
		t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try{
			for(int i =0;i<5;i++){
				System.out.println("Thread : "+name+" "+i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e){
			System.out.println("Thread : "+name+"Interrupted");
		}
		
		System.out.println("Thread "+name+" Exiting" );
	}

}

public class JoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadSample ob1 = new ThreadSample("One");
		ThreadSample ob2 = new ThreadSample("Two");
		ThreadSample ob3 = new ThreadSample("Three");
		
		System.out.println("Thread one is alive : "+ob1.t.isAlive());
		System.out.println("Thread two is alive : "+ob2.t.isAlive());
		System.out.println("Thread three is alive : "+ob3.t.isAlive());
		
		try{
		ob1.t.join();
		ob2.t.join();
		ob3.t.join();
		}
		catch(InterruptedException e){
			System.out.println("Main thread interrupted");
		}
		
		System.out.println("Thread one is alive : "+ob1.t.isAlive());
		System.out.println("Thread two is alive : "+ob2.t.isAlive());
		System.out.println("Thread three is alive :"+ob3.t.isAlive());
		
		
	}

}
