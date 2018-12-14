package algo.day10;

/**
 * str1�ĳ���ΪM��str2�ĳ���ΪN�����ɴ�СΪM*N�ľ���dp
 * dp[i][j] �ĺ�����str1[0....i] �� str2[0......j]�Ĺ��������еĳ��� 
 * ���dp[i][0] dp[0][i] Ϊ1 ����Ͷ�Ϊ1
 * @author Jianxiong Rao
 *
 */
public class DemoFive {

	public static int findLCS(String A,int n,String B,int m) {
		char[] arrA = A.toCharArray();
		char[] arrB = B.toCharArray();
		// n * m ���� A * B
		int[][] dp = new int[n][m];
		//��
		for(int i=0,temp = 0;i<n;i++) {
			if(arrA[i] ==  arrB[0]) {
				temp = 1;
			}
			dp[i][0] = temp; 
		}
		//��
		for(int i = 0,temp = 0;i<m;i++) {
			if(arrA[0] == arrB[i]) {
				temp = 1;
			}
			dp[0][i]= temp; 
		}
		
		for(int i = 1;i<n;i++) {
			for(int j = 1;j< n;j++) {
				//i j λ�õ���һ�С���һ�С����жԽ���λ�ö��ǹ��ɹ������еĳ���
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
