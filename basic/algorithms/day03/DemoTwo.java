package algo.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * ��дһ���ֻ࣬��������ջ�ṹʵ�ֶ��У�֧�ֶ��еĻ�������(push,pop) push�ǴӶ���ͷ����Ԫ�أ�pop�ǴӶ���ͷ����Ԫ��
 * ����һ����������ope�����ĳ���n,����Ԫ��Ϊ��������push������Ϊ0����pop��������֤�������кϷ���һ����pop������
 * �뷵��pop�Ľ�����С���������[1,2,3,0,4,0],6����[1,2]  ��һ��push���� 3 2 1 ,Ȼ�� pop �� 3��push 4, 4 2 1,Ȼ����� pop 4 ,ʣ�� 2 1 �����������[1,2]
 * ���������
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
		int[] result = new int[stackPush.size()];// �����������鲻����
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = stackPush.pop();
		}
		return result;
	}

}
