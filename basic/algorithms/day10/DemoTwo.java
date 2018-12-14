package algo.day10;

/**
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法
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
