package algo.day10;

/**
 * ��n��̨�ף�һ����ÿ����һ���������������ж���������n��̨�׵ķ���
 * @author Jianxiong Rao
 *
 */
public class DemoTwo {

	public static int stepsAll(int n) {
		if(n < 1) {
			return 0;
		}
		if(n ==1 || n ==2) {
			return n;
		}
		return stepsAll(n-1) + stepsAll(n-2);
	}
}
