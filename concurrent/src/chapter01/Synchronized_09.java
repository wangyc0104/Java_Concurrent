package chapter01;

/**
 * synchronized关键字<br>
 * 同步粒度问题<br>
 * 尽量在商业开发中避免同步方法。使用同步代码块。 细粒度解决同步问题。<br>
 * 可以提高效率。<br>
 * 
 * @author Yicheng Wang
 */
public class Synchronized_09 {

	synchronized void m1() {
		// 前置逻辑
		System.out.println("同步逻辑");
		// 后置逻辑
	}

	void m2() {
		// 前置逻辑
		synchronized (this) {
			System.out.println("同步逻辑");
		}
		// 后置逻辑
	}

}