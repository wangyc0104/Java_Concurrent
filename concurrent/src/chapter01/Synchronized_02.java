package chapter01;

/**
 * synchronized关键字
 * 同步方法 - static
 * 静态同步方法，锁的是当前类型的类对象。在本代码中就是Synchronized_02.class
 * @author Yicheng Wang
 */
import java.util.concurrent.TimeUnit;

public class Synchronized_02 {
	private static int staticCount = 0;

	public static synchronized void testSync4() {
		System.out.println(Thread.currentThread().getName() + " staticCount = " + staticCount++);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void testSync5() {
		synchronized (Synchronized_02.class) {
			System.out.println(Thread.currentThread().getName() + " staticCount = " + staticCount++);
		}
	}

}
