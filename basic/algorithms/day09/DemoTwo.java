package algo.day09;

/**
 * n只蚂蚁从正n边型的n个定点沿着边移动，速度是相同的，问它们碰头的概率是多少？
 * 给定一个正整数n,请返回一个数组，其中两个元素分别为结果的分子和分母，请化为最简分数。
 * @author Jianxiong Rao
 *
 */
public class DemoTwo {

	public static int[] ants(int n) {
		int[] result = new int[] {1,1};
		 result[1] = (int) Math.pow(2, n);
		result[0] = result[1] - 2;
		int gcd = maxGcd(result[0], result[1]);
		result[0] /= gcd;
		result[1] /= gcd;
		return result;
	}
	
	private static int maxGcd(int x,int y) {
	
//		int max = x> y?x:y;
//		int min = x>y?y:x;
//		if(max - min == min) {
//			return min;
//		}
//		return maxGcd(max, min);
		if(x % y == 0)return y;
		return maxGcd(y, x%y);
	}
}
