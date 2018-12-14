package algo.day10;

/**
 * һ��������һ���ĳ���W����N����Ʒ��ÿ�������Լ��ļ�ֵ����¼������v�У�Ҳ�����Լ�����������¼������w�У�
 * ÿ����Ʒֻ��ѡ��Ҫװ�뱳�����ǲ�װ�뱳����Ҫ���ڲ������������ص�ǰ���£�ѡ����Ʒ���ܼ�ֵ���
 * 
 * ��Ʒ���1��N��Ҳ����v�ĳ���ΪN��w�ĳ���ΪM���½���СΪ N * (cap+1)�ľ��� dp[x][y] ����ǰx����Ʒ������������y��ʱ������ֵ
 * ��ô����dp[x][y]����Ҫ�����Ƿ�ѡ��x����Ʒ��ѡ����ǰx-1����Ʒ���ó���y-w[x],��ѡ�����ܳ���y
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoSix {

	public static int maxValue(int[] v, int[] w, int n, int cap) {
		int[][] dp = new int[n][cap + 1];

		// ��һ�У�ǰx����Ʒ������������0
		for (int i = 0; i < n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < cap + 1; i++) {
			// �������������أ���һ�У��ڳ����������غ���v[0]
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
