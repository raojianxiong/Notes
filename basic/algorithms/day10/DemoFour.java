package algo.day10;

/**
 * ��������arr,����arr������������г��ȡ�
 * ����arr=[2,1,5,3,6,4,8,9,7],�����������Ϊ[1,3,4,8,9],���Է�����������еĳ���5��
 * ��������arr������arr������������г���
 * @author Jianxiong Rao
 *
 */
public class DemoFour {

	/**
	 * dp[i] ��ʾ�ڱ����� arr[i] �������β������£�
	 * arr[0......i] �е������������г��ȡ�
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
				//��ǰ����֮ǰ��ÿ����j�Ƚϣ��Ƿ���С��data[i] ,0..jλ�õ����������г����Ƿ����max
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
