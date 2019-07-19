package chapter01;

import java.util.concurrent.TimeUnit;

/**
 * synchronized关键字<br>
 * 同步方法 - 调用其他同步方法<br>
 * 锁可重入。 同一个线程，多次调用同步代码，锁定同一个锁对象，可重入。<br>
 * 
 * @author Yicheng Wang
 */
public class Synchronized_06 {

	synchronized void m1() { // 锁this
		System.out.println("m1 start");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		m2();
		System.out.println("m1 end");
	}

	synchronized void m2() { // 锁this
		System.out.println("m2 start");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m2 end");
	}

	public static void main(String[] args) {

		new Synchronized_06().m1();

	}

}
