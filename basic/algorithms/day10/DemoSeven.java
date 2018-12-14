package algo.day10;

/**
 * 给定两个字符串str1和str2，再给定三个整数ic、dc、和rc,分别代表插入、删除、和替换一个字符的代价。
 * 返回将str1编辑成str2的最小代价。
 * 比如，str1="abc",str2="adc",ic=5,dc=3,rc=2。
 * 从”abc"编辑成"adc"，把"b"替换成"d"是代价最小的，所以返回2。
 * 再比如，str1="abc",str2="adc",ic=5,dc=3,rc=100。
 * 从"abc"编辑成"adc",先删除b，然后再插入"d"是代价最小的，所以返回8。
 * 给定两个字符串A和B，以及它们的长度和三种操作的代价，请返回将A变成B的最小代价。
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoSeven {

	public static int findMinCost(String A,int n,String B,int m,int ic,int dc,int rc) {
		int[][] dp = new int[n+1][m+1];
		//矩阵第一行，第一列都设置成 i * ic 或者 i * dc ,考虑到0 行0列是空字符串
		for(int i = 0 ;i< n+1;i++) {
			dp[i][0] = i * dc;
		}
		for(int i = 0;i<m + 1;i++) {
			dp[0][i]= i* ic; 
		}
		//注意 矩阵中对应A B 字符串是从位置1开始的，0位置是空字符串，所以dp[i][j] 是指字符串0到i-1位置，0到j-1位置
		for(int i = 1;i< n+1;i++) {
			for(int j = 1;j<m+1;j++) {
				int temp1=0,temp2=0,result;
				//画个矩阵图，看两遍就明白了，就是a变化到b的可能性
				temp1 = Math.min(dp[i][j-1]+ic, dp[i-1][j]+dc);
				if(A.charAt(i-1) == B.charAt(i-1)) {
					temp2 = dp[i-1][j-1];
				}else {
					temp2 = dp[i-1][j-1] + rc;
				}
				result = Math.min(temp1, temp2);
				dp[i][j]= result; 
			}
		}
		return dp[n][m];
	}
}
