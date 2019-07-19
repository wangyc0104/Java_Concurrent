package chapter06;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 基于数组的阻塞队列
 * 
 * @author Yicheng Wang
 */
public class ArrayBlockingQueueDemo {

	final BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

	public static void main(String[] args) {
		final ArrayBlockingQueueDemo t = new ArrayBlockingQueueDemo();

		for (int i = 0; i < 5; i++) {
			// System.out.println("add method : " + t.queue.add("value"+i));
			// try {
			// t.queue.put("put"+i);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			// System.out.println("put method : " + i);
			// System.out.println("offer method : " + t.queue.offer("value"+i));
			try {
				System.out.println("offer method : " + t.queue.offer("value" + i, 1, TimeUnit.SECONDS));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(t.queue);
	}

}
