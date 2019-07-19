package chapter07;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ConcurrentLinkedQueue的并发丢失问题
 * 
 * @author Yicheng Wang
 * 
 */
public class Test_02 {

	static Queue<String> list = new ConcurrentLinkedQueue<>();

	static {
		for (int i = 0; i < 10000; i++) {
			list.add("String " + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						String str = list.poll();
						if (str == null) {
							break;
						}
						System.out.println(Thread.currentThread().getName() + " - " + str);
					}
				}
			}, "Thread" + i).start();
		}
	}

}
