package algo.day10;

/**
 * 一个背包有一定的承重W，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，记录在数组w中，
 * 每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大
 * 
 * 物品编号1到N，也就是v的长度为N，w的长度为M，新建大小为 N * (cap+1)的矩阵 dp[x][y] 代表前x件物品，不超过重量y的时候最大价值
 * 那么计算dp[x][y]就需要考虑是否选择x件物品，选择，则前x-1件物品不得超过y-w[x],不选择则不能超过y
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoSix {

	public static int maxValue(int[] v, int[] w, int n, int cap) {
		int[][] dp = new int[n][cap + 1];

		// 第一列，前x件物品，重量不超过0
		for (int i = 0; i < n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < cap + 1; i++) {
			// 不超过背包承重，第一行，在超过背包承重后都是v[0]
			if (i >= w[0]) {
				dp[0][i] = v[0];
			} else {
				dp[0][i] = 0;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < cap + 1; j++) {
				if (j - w[i] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		int result = dp[n - 1][cap];
		return result;
	}
}
