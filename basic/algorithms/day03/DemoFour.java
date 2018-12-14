package algo.day03;

import java.util.Stack;

public class DemoFour {

	public int[] sort(int[] data) {
		if (data == null) {
			return null;
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = data.length - 1; i >= 0; i--) {
			stack.push(data[i]);
		}
		Stack<Integer> help = new Stack<>();
		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (help.isEmpty() || top <= help.peek()) {
				help.push(top);
			} else {

				while (!help.isEmpty() && help.peek() < top) {
					int max = help.pop();
					if (max < top) {
						stack.push(max);
					}
				}
				help.push(top);

			}
		}
		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
//		while (!stack.isEmpty()) {
//			System.out.println(stack.pop());
//		}
		for(int i = 0;i<data.length;i++) {
			data[i]= stack.pop(); 
		}

		return data;
	}
}
