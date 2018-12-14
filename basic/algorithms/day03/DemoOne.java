package algo.day03;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * ʵ��һ�������ջ����ʵ��ջ�Ļ������ܵĻ�������ʵ�ַ���ջ����СԪ�صĲ���getMin Ҫ��pop ��push ��getMin
 * ������ʱ�临�Ӷȶ���O(1) ������Ƶ�ջ���Ϳ���ʹ���ֳɵ�ջ�ṹ
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoOne {

	private Stack<Integer> stackData = new Stack<>();
	private Stack<Integer> stackMin = new Stack<>();

	public int pop() {
		if (!stackData.isEmpty()) {
			// �����push��elseע�Ͷ�Ӧ
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
			// �������ﲻҪpush�Ļ�����ô��pop����ע��
			stackMin.push(stackMin.peek());
		}
	}

}
