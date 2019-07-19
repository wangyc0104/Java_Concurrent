package chapter01;

/**
 * synchronized关键字<br>
 * 同步方法 - 原子性<br>
 * 加锁的目的： 就是为了保证操作的原子性<br>
 * 
 * @author Yicheng Wang
 */
public class Synchronized_03 implements Runnable {

	private int count = 0;

	@Override
	public/* synchronized */void run() {
		System.out.println(Thread.currentThread().getName() + " count = " + count++);
	}

	public static void main(String[] args) {
		Synchronized_03 t = new Synchronized_03();
		for (int i = 0; i < 5; i++) {
			new Thread(t, "Thread - " + i).start();
		}
	}

}
