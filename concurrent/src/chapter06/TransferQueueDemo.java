
package chapter06;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * 转移队列 - LinkedTransferQueue <br>
 * add - 队列会保存数据，不做阻塞等待。 <br>
 * transfer - 是TransferQueue的特有方法。必须有消费者（take()方法的调用者）。 <br>
 * 如果没有任意线程消费数据，transfer方法阻塞。一般用于处理即时消息。 <br>
 * 
 * @author Yicheng Wang
 */
public class TransferQueueDemo {
	
	TransferQueue<String> queue = new LinkedTransferQueue<>();
	
	public static void main(String[] args) {
		final TransferQueueDemo t = new TransferQueueDemo();
		
		/*new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName() + " thread begin " );
					System.out.println(Thread.currentThread().getName() + " - " + t.queue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "output thread").start();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			t.queue.transfer("test string");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					t.queue.transfer("test string");
					// t.queue.add("test string");
					System.out.println("add ok");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName() + " thread begin " );
					System.out.println(Thread.currentThread().getName() + " - " + t.queue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "output thread").start();
		
	}

}
