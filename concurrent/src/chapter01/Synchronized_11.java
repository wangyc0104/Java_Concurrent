package chapter01;

/**
 * synchronized关键字<br>
 * 常量问题<br>
 * 在定义同步代码块时，不要使用常量对象作为锁对象。<br>
 * 
 * @author Yicheng Wang
 */
public class Synchronized_11 {
	String s1 = "hello";
	String s2 = new String("hello"); // new关键字，一定是在堆中创建一个新的对象。
	Integer i1 = 1;
	Integer i2 = 1;

	void m1() {
		synchronized (i1) {
			System.out.println("m1()");
			while (true) {
				// 无尽的循环
			}
		}
	}

	void m2() {
		synchronized (i2) {
			System.out.println("m2()");
			while (true) {
				// 无尽的循环
			}
		}
	}

	public static void main(String[] args) {
		final Synchronized_11 t = new Synchronized_11();
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
