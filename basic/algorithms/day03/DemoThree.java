package algo.day03;

import java.util.Stack;

/**
 * ʵ��һ��ջ�����򣬵���ֻ���õݹ麯�������ջ�����pop������ʵ�֣� �������Լ�������������ݽṹ������һ����������A��Ϊ������ջ��
 * ͬʱ�������Ĵ�Сn,�뷵��������ջ�� [4��3��2��1]��4 ���� [1��2��3��4]
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoThree {
	public int[] reverseStack(int[] data, int n) {
		if(data == null) {
			return null;
		}//                                       |  1  |
		Stack<Integer> stack = new Stack<>();//   |  2  |
		for(int i =n-1;i>=0;i--) {//              |  3  |
			stack.push(data[i]);// 1,2,3,4        |  4  |
		}
//		System.out.println("ջ�� "+stack.peek());
		reverse(stack);
//		System.out.println("ջ�� "+stack.peek());
		for(int i =n-1;i>0;i--) {
			data[i]= stack.pop(); 
			
		}
		return data;
	}
	private void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int result = popStackBottom(stack);
		reverse(stack);
		stack.push(result);
	}
	private int popStackBottom(Stack<Integer> stack) {
		int data = stack.pop();
		if(!stack.isEmpty()) {
			int last = popStackBottom(stack);
			stack.push(data);
			return last;
		}
		return data;
	}
}
