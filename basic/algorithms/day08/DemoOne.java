package algo.day08;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��n���ŷ⣬����n���ţ����ڰ����ó�������װ��ȥ��Ҫ��ÿ���Ų���װ����ԭ�����ŷ⣬���ж�����װ����
 * 
 * ������n���������ţ�������Ϸ��������ж��ٸ����Ϸ���ָÿһ�����Ŷ������ҵ���֮��Ե����ţ�����n=1ʱ��()�ǺϷ��ģ�����)(�ǲ��Ϸ���
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
	 * 1.���ʣ�������ŵ��������������࣬��Ϊ�Ƿ������Ŷԣ� 
	 * 2.���ʣ�������ź�����������ȣ���ֻ������һ�������ţ�
	 * 3.���ʣ�����������С��������������������������Ż������š�
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
		if (ls <= rs && ls != 0) {//�տ�ʼ��������
			solve(n, ls - 1, rs, str + "(", queue);
		}
		if (ls < rs) {//��Ҫ�� ��������
			solve(n, ls, rs - 1, str + ")", queue);
		}

	}
}
