package chapter01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 门闩 - CountDownLatch<br>
 * 可以和锁混合使用，或替代锁的功能。<br>
 * 在门闩未完全开放之前等待。当门闩完全开放后执行。<br>
 * 避免锁的效率低下问题。<br>
 * 
 * @author Yicheng Wang
 */
public class CountDownLatch_01 {
	CountDownLatch latch = new CountDownLatch(5);

	void m1() {
		try {
			latch.await();// 等待门闩开放。
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m1() method");
	}

	void m2() {
		for (int i = 0; i < 10; i++) {
			if (latch.getCount() != 0) {
				System.out.println("latch count : " + latch.getCount());
				latch.countDown(); // 减门闩上的锁。
			}
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("m2() method : " + i);
		}
	}

	public static void main(String[] args) {
		final CountDownLatch_01 t = new CountDownLatch_01();
		new Thread(new Runnable() {
			@Override
			public void run() {
				t.m1();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				t.m2();
			}
		}).start();
	}

}
