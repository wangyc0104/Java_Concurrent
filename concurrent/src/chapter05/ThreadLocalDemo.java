package chapter05;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal本质上就是一个Map <br>
 * key - Thread.getCurrentThread() <br>
 * value - 线程需要保存的变量 <br>
 * ThreadLocal.set(value) -> map.put(Thread.getCurrentThread(), value) <br>
 * ThreadLocal.get() -> map.get(Thread.getCurrentThread()) <br>
 * 内存问题 ： 在并发量高的时候，可能有内存溢出 <br>
 * 使用ThreadLocal的时候，一定注意回收资源问题 <br>
 * 每个线程结束之前，将当前线程保存的线程变量一定要删除：即ThreadLocal.remove()<br>
 * 
 * @author Yicheng Wang
 */
public class ThreadLocalDemo {

	volatile static String name = "BigCheng";
	static ThreadLocal<String> tl = new ThreadLocal<>();

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name);
				System.out.println(tl.get());
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				name = "SmallCheng";
				tl.set("wangwu");
			}
		}).start();
	}

}
