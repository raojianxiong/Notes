package algo.day03;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上再实现返回栈中最小元素的操作getMin 要求：pop 、push 、getMin
 * 操作的时间复杂度都是O(1) 并且设计的栈类型可以使用现成的栈结构
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoOne {

	private Stack<Integer> stackData = new Stack<>();
	private Stack<Integer> stackMin = new Stack<>();

	public int pop() {
		if (!stackData.isEmpty()) {
			// 这里和push中else注释对应
//			if (stackData.peek() <= stackMin.peek()) {
//				stackMin.pop();
//			}
			stackMin.pop();
			return stackData.pop();
		}
		throw new EmptyStackException();
	}

	public int size() {
		return stackData.size();
	}

	public int getMin() {
		return stackMin.peek();
	}

	public void push(int data) {
		stackData.push(data);
		if (stackMin.isEmpty() || data <= stackMin.peek()) {
			stackMin.push(data);
		} else {
			// 假如这里不要push的话，那么在pop是请注意
			stackMin.push(stackMin.peek());
		}
	}

}
