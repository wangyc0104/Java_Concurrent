package chapter01;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile关键字<br>
 * volatile的非原子性问题<br>
 * volatile， 只能保证可见性，不能保证原子性。<br>
 * 不是加锁问题，只是内存数据可不可见的问题。<br>
 * 
 * @author Yicheng Wang
 */
public class Volatile_02 {

	volatile int count = 0;

	/* synchronized */void m() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final Volatile_02 t = new Volatile_02();
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(new Runnable() {
				@Override
				public void run() {
					t.m();
				}
			}));
		}
		for (Thread thread : threads) {
			thread.start();
			// try {
			// thread.join();
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(t.count);
	}
}
