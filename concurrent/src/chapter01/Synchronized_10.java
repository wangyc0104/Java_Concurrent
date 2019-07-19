package chapter01;

import java.util.concurrent.TimeUnit;

/**
 * synchronized关键字<br>
 * 锁对象变更问题<br>
 * 同步代码一旦加锁后，那么会有一个临时的锁引用执行锁对象，和真实的引用无直接关联。<br>
 * 在锁未释放之前，修改锁对象引用，不会影响同步代码的执行。<br>
 * 
 * @author Yicheng Wang
 */
public class Synchronized_10 {
	Object o = new Object();

	int i = 0;
	int a(){
		try{
			/*
			 * return i ->
			 * int _returnValue = i; // 0;
			 * return _returnValue;
			 */
			return i;
		} finally {
			i = 10;
		}
	}

	void m() {
		System.out.println(Thread.currentThread().getName() + " start");
		synchronized (o) {
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " - " + o);
			}
		}
	}

	public static void main(String[] args) {
		final Synchronized_10 t = new Synchronized_10();
		new Thread(new Runnable() {
			@Override
			public void run() {
				t.m();
			}
		}, "thread1").start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				t.m();
			}
		}, "thread2");
		t.o = new Object();
		thread2.start();

		System.out.println(t.i);
		System.out.println(t.a());
		System.out.println(t.i);
	}
	
}
