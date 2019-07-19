package chapter01;

import java.util.concurrent.TimeUnit;

/**
 * volatile关键字<br>
 * volatile的可见性<br>
 * 通知OS操作系统底层，在CPU计算过程中，都要检查内存中数据的有效性。保证最新的内存数据被使用。<br>
 * 
 * @author Yicheng Wang
 */
public class Volatile_01 {

	volatile boolean b = true;

	void m() {
		System.out.println("start");
		while (b) {
		}
		System.out.println("end");
	}

	public static void main(String[] args) {
		final Volatile_01 t = new Volatile_01();
		new Thread(new Runnable() {
			@Override
			public void run() {
				t.m();
			}
		}).start();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t.b = false;
	}

}
