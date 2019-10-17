package demo.synchronization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Chat {

	boolean flag = false;

	public synchronized void question(String msg) throws InterruptedException {
		if (flag) {
			wait();
		}
		System.out.println(Thread.currentThread().getName() + ": " + msg);
		flag = true;
		notify();
	}

	public synchronized void answer(String msg) throws InterruptedException {
		if (!flag) {
			wait();
		}
		System.out.println(Thread.currentThread().getName() + ": " + msg);
		flag = false;
		notify();
	}

}

class QuestionThread implements Runnable {
	Chat c;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public QuestionThread(Chat c) {
		this.c = c;
		new Thread(this, "Question").start();
	}

	@Override
	public void run() {
		String msg = null;
		do {
			try {
				msg = br.readLine();
				c.question(msg);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!msg.contentEquals("bye"));

	}

}

class AnswerThread implements Runnable {
	Chat c;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public AnswerThread(Chat c) {
		this.c = c;
		new Thread(this, "Answer").start();
	}

	@Override
	public void run() {
		String msg = null;
		do {
			try {
				msg = br.readLine();
				c.answer(msg);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!msg.contentEquals("bye"));
	}

}

public class WaitNotifyDemo_3 {

	public static void main(String[] args) {
		Chat c = new Chat();
		new QuestionThread(c);
		new AnswerThread(c);

	}

}
