package chapter05;

/**
 * 内部类实现单例
 * 
 * @author Yicheng Wang
 */
public class InnerClassSingletonDemo {

	private InnerClassSingletonDemo() {
	}

	private static class Inner {
		private static InnerClassSingletonDemo t = new InnerClassSingletonDemo();
	}

	public static InnerClassSingletonDemo getInstance() {
		return Inner.t;
	}
}
