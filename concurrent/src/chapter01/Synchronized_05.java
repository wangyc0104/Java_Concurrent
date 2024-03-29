package chapter01;

import java.util.concurrent.TimeUnit;

/**
 * synchronized关键字<br>
 * 同步方法 - 多方法调用原子性问题（业务）<br>
 * 同步方法只能保证当前方法的原子性，不能保证多个业务方法之间的互相访问的原子性。<br>
 * 注意在商业开发中，多方法要求结果访问原子操作，需要多个方法都加锁，且锁定统一个资源。<br>
 * 一般来说，商业项目中，不考虑业务逻辑上的脏读问题。<br>
 * 
 * @author Yicheng Wang
 */
public class Synchronized_05 {
	private double d = 0.0;

	public synchronized void m1(double d) {
		try {
			// 模拟复杂的业务逻辑代码。
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.d = d;
	}

	public double m2() {
		return this.d;
	}

	public static void main(String[] args) {
		final Synchronized_05 t = new Synchronized_05();

		new Thread(new Runnable() {
			@Override
			public void run() {
				t.m1(100);
			}
		}).start();
		System.out.println(t.m2());
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.m2());
	}

}
