package algo.day10;

/**
 * 给定数组arr,返回arr的最长递增子序列长度。
 * 比如arr=[2,1,5,3,6,4,8,9,7],最长递增子序列为[1,3,4,8,9],所以返回这个子序列的长度5。
 * 给定数组arr，返回arr的最长递增子序列长度
 * @author Jianxiong Rao
 *
 */
public class DemoFour {

	/**
	 * dp[i] 表示在必须以 arr[i] 这个数结尾的情况下，
	 * arr[0......i] 中的最大递增子序列长度。
	 * @param data
	 * @param n
	 * @return
	 */
	public static int longestIncreasingSubsequence(int[] data,int n) {
		if(data == null || n == 0) {
			return 0;
		}
		int[] dp = new int[n];
		int result = 0;
		dp[0] = 1;
		for(int i = 1;i<n;i++) {
			int max = 0,j = 0;
			while(j<i) {
				//当前数与之前的每个数j比较，是否是小于data[i] ,0..j位置的最大递增序列长度是否大于max
				if(data[j]< data[i]&& dp[j]> max) {
					max = dp[j];
				}
				j++;
			}
			dp[i]= max + 1; 
		}
//		System.out.println("dp 1 -> "+ dp[2]);
		for(int i = 0;i<n;i++) {
			if(result < dp[i]) {
				result = dp[i];
			}
		}
		return result;
	}
}
