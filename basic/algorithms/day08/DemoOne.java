package algo.day08;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有n个信封，包含n封信，现在把信拿出来，再装回去，要求每封信不能装回它原来得信封，问有多少种装法？
 * 
 * 假设有n对左右括号，请求出合法的排列有多少个？合法是指每一个括号都可以找到与之配对的括号，比如n=1时，()是合法的，但是)(是不合法的
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoOne {
	public long countWays(int n) {
		int a = 0;
		int b = 1;
		if (n <= 1)
			return a;
		if (n == 2)
			return b;
		long result = 0;
		long x = 0;
		long y = 1;
		for (int i = 3; i <= n; i++) {
			result += (i - 1) * (x + y) % 1000000007;
			x = y;
			y = result;
		}
		return result;
	}

	public static void main(String[] args) {
		printMatch(3);
	}

	public static void printMatch(int n) {
		Queue<String> queue = new LinkedList<>();
		solve(n, n, n, "", queue);
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
	}

	/**
	 * 1.如果剩余左括号的数比右括号数多，则为非法的括号对； 
	 * 2.如果剩余左括号和右括号数相等，则只能增加一个左括号；
	 * 3.如果剩余的左括号数小于右括号数，则可以增加左括号或右括号。
	 * 
	 * @param n
	 * @param ls
	 * @param rs
	 * @param str
	 * @param queue
	 */
	private static void solve(int n, int ls, int rs, String str, Queue<String> queue) {

//		if(ls ==rs && ls + rs == 2*n) {
//			System.out.println();
//		}
//		if( ls < rs || ls + rs >= 2*n) {
//			return;
//		}
//		//int index = ls +rs;
//		queue.add("(");
//		solve(n, ls+1, rs, queue);
//		queue.add(")");
//		solve(n, ls, rs+1, queue);
		if (ls == 0 && rs == 0) {
			queue.add(str);
			return;
		}
		if (ls <= rs && ls != 0) {//刚开始加左括号
			solve(n, ls - 1, rs, str + "(", queue);
		}
		if (ls < rs) {//需要加 右括号了
			solve(n, ls, rs - 1, str + ")", queue);
		}

	}
}
