package chapter06;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 并发容器 - LinkedBlockingQueue <br>
 * 阻塞容器 <br>
 * put & take - 自动阻塞 <br>
 * put自动阻塞， 队列容量满后，自动阻塞 <br>
 * take自动阻塞方法， 队列容量为0后，自动阻塞 <br>
 * 
 * @author Yicheng Wang
 */
public class LinkedBlockingQueueDemo {

	final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
	final Random r = new Random();

	public static void main(String[] args) {
		final LinkedBlockingQueueDemo t = new LinkedBlockingQueueDemo();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						t.queue.put("value" + t.r.nextInt(1000));
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "producer").start();

		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							System.out.println(Thread.currentThread().getName() + " - " + t.queue.take());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}, "consumer" + i).start();
		}
	}

}
