package algo.day03;

import java.util.Stack;

/**
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现， 而不能自己申请另外的数据结构，给定一个整数数组A即为给定的栈，
 * 同时给定它的大小n,请返回逆序后的栈， [4，3，2，1]，4 返回 [1，2，3，4]
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
//		System.out.println("栈顶 "+stack.peek());
		reverse(stack);
//		System.out.println("栈顶 "+stack.peek());
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
