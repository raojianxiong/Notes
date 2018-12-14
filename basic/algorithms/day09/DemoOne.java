package algo.day09;

/**
 * 有2k只足球队，有k-1个强队，其余都是弱队，
 * 随机把它们分成k组，每组两个队，问两强相遇的概率是多大？给定一个数k，
 * 请返回一个数组，其中有两个元素，分别为最终的分子和分母，请化成最简分数
 * @author Jianxiong Rao
 *
 */
public class DemoOne {

	public static int[] championship(int k) {
		int[] result = new int[] {1,1};
		for(int i = 2*k-1;i>0;i-=2) {
			result[1] *= i;
		}
		//最后剩两个队
		for(int i = k+1;i>2;i--) {
			result[0] *=i;
		}
		result[0] = result[1] - result[0];
		int maxGcd = maxGcd(result[0], result[1]);
		result[0] /=maxGcd;
		result[1] /= maxGcd;
		return result;
		
	}
	/**
	 * 求两个数的公因子
	 * @param x
	 * @param y
	 * @return
	 */
	private static int maxGcd(int x,int y) {
		if(x%y == 0) {return y;}
		else {
			return maxGcd(y, x%y);
		}
	}
}
