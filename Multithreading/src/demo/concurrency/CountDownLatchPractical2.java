package demo.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

abstract class BaseHealthChecker implements Runnable {
	private String serviceName;
	private CountDownLatch cdl;
	private boolean serviceUp;

	public BaseHealthChecker(String serviceName, CountDownLatch cdl) {
		this.cdl = cdl;
		this.serviceName = serviceName;
		serviceUp = false;
	}

	@Override
	public void run() {
		try {
			verifyService();
			serviceUp = true;
		} catch (Throwable t) {
			t.printStackTrace(System.err);
			serviceUp = false;
		} finally {
			if (cdl != null)
				cdl.countDown();
		}
	}

	public boolean isServiceUp() {
		return serviceUp;
	}

	public String serviceName() {
		return serviceName;
	}

	public abstract void verifyService();

}

class NetworkChecker extends BaseHealthChecker {

	public NetworkChecker(CountDownLatch cdl) {
		super("Network Health Checker", cdl);
	}

	@Override
	public void verifyService() {
		System.out.println("Checking " + this.serviceName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.serviceName() + " is UP");
	}

}

class DatabaseHealthChecker extends BaseHealthChecker {

	public DatabaseHealthChecker(CountDownLatch cdl) {
		super("DatabaseHealthChecker", cdl);
	}

	@Override
	public void verifyService() {
		System.out.println("Checking " + this.serviceName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.serviceName() + " is UP");
	}

}

class ApplicationStartupUtil {

	static List<BaseHealthChecker> services;
	static CountDownLatch cdl;

	private ApplicationStartupUtil() {

	}

	private static ApplicationStartupUtil instance = new ApplicationStartupUtil();

	public ApplicationStartupUtil getInstance() {
		return instance;
	}

	public static boolean healthCheck() throws InterruptedException {

		cdl = new CountDownLatch(2);
		services = new ArrayList<>();
		services.add(new NetworkChecker(cdl));
		services.add(new DatabaseHealthChecker(cdl));

		Executor exectors = Executors.newFixedThreadPool(services.size());

		for (BaseHealthChecker baseHealthChecker : services)
			exectors.execute(baseHealthChecker);

		cdl.await();

		for (BaseHealthChecker baseHealthChecker : services) {
			if (!baseHealthChecker.isServiceUp())
				return false;
		}
		return true;
	}

}

public class CountDownLatchPractical2 {

	public static void main(String[] args) throws InterruptedException {
		boolean result = ApplicationStartupUtil.healthCheck();
		System.out.println("External services validation completed !! Result was :: " + result);
	}

}
