package chapter01;

import java.util.concurrent.TimeUnit;

/**
 * synchronized关键字<br>
 * 同步方法 - 锁与异常<br>
 * 当同步方法中发生异常的时候，自动释放锁资源。不会影响其他线程的执行。<br>
 * 注意，同步业务逻辑中，如果发生异常如何处理。<br>
 * 
 * @author Yicheng Wang
 */
public class Synchronized_08 {
	int i = 0;

	synchronized void m() {
		System.out.println(Thread.currentThread().getName() + " - start");
		while (true) {
			i++;
			System.out.println(Thread.currentThread().getName() + " - " + i);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i == 5) {
				i = 1 / 0;
			}
		}
	}

	public static void main(String[] args) {
		final Synchronized_08 t = new Synchronized_08();
		new Thread(new Runnable() {
			@Override
			public void run() {
				t.m();
			}
		}, "t1").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				t.m();
			}
		}, "t2").start();
	}

}
