package algo.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 编写一个类，只能用两个栈结构实现队列，支持队列的基本操作(push,pop) push是从对列头加入元素，pop是从队列头弹出元素
 * 给定一个操作序列ope及它的长度n,其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，
 * 请返回pop的结果序列。测试样例[1,2,3,0,4,0],6返回[1,2]  第一次push后是 3 2 1 ,然后 pop 出 3，push 4, 4 2 1,然后就是 pop 4 ,剩下 2 1 ，结果序列是[1,2]
 * 这个有问题
 * @author Jianxiong Rao
 *
 */
public class DemoTwo {
	private Stack<Integer> stackPush = new Stack<>();
	private Stack<Integer> stackPop = new Stack<>();

	public List<Integer> twoStack(int[] data, int length) {
		if (data == null) {
			return null;
		}
		List<Integer> result = new ArrayList<>();
		stackPush.clear();
		stackPop.clear();
		for (int i : data) {
			if (i > 0) {
				// push
				push(i);
			} else if (i == 0) {
				result.add(pop());
			}
		}

		return result;
	}

	private void push(int value) {
		stackPush.push(value);
	}

	private int pop() {
		if (stackPop.isEmpty()) {

			while (!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
			return stackPop.pop();
		}
		return stackPop.pop();

	}

	public int[] twoStack2(int[] data, int length) {
		if (data == null) {
			return null;
		}
		stackPush.clear();
		for (int i : data) {
			if (i != 0) {
				// push
				stackPush.push(i);
			} else {
				stackPush.pop();
			}
		}
		int[] result = new int[stackPush.size()];// 这里用了数组不可以
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = stackPush.pop();
		}
		return result;
	}

}
