package algo.day10;

/**
 * str1的长度为M，str2的长度为N，生成大小为M*N的矩阵dp
 * dp[i][j] 的含义是str1[0....i] 与 str2[0......j]的公共子序列的长度 
 * 如果dp[i][0] dp[0][i] 为1 后面就都为1
 * @author Jianxiong Rao
 *
 */
public class DemoFive {

	public static int findLCS(String A,int n,String B,int m) {
		char[] arrA = A.toCharArray();
		char[] arrB = B.toCharArray();
		// n * m 矩阵 A * B
		int[][] dp = new int[n][m];
		//行
		for(int i=0,temp = 0;i<n;i++) {
			if(arrA[i] ==  arrB[0]) {
				temp = 1;
			}
			dp[i][0] = temp; 
		}
		//列
		for(int i = 0,temp = 0;i<m;i++) {
			if(arrA[0] == arrB[i]) {
				temp = 1;
			}
			dp[0][i]= temp; 
		}
		
		for(int i = 1;i<n;i++) {
			for(int j = 1;j< n;j++) {
				//i j 位置的上一行、上一列、还有对角线位置都是构成公共序列的长度
				int max = Math.max(dp[i-1][j], dp[i][j-1]);
				if(arrA[i]== arrB[i] ) {
					max = Math.max(max, dp[i-1][j-1]+1);
				}
				dp[i][j]= max; 
			}
		}
		return dp[n-1][m-1];
		
	}
}
