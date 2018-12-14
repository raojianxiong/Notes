package algo.day02;

/**
 * ������һ���к��ж��ź���ľ��� �����һ����Ч�㷨�������ҵ��������Ƿ���ֵx
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoFive {
	/**
	 * n��m�� ÿ��ÿ�ж��Ǵ�С�������������
	 * �ڶ��ּ� O��M+N)
	 * @param data
	 * @param n
	 * @param m
	 * @return
	 */
	public static boolean sort(int[][] data, int n, int m, int x) {
		for (int j = m - 1; j >= 0; j--) {
			int i = 0;
			for (; i < n; i++) {
				if (data[i][j] == x) {
					return true;
				}
				if (data[i][j] < x) {
					break;
				}

			}
			if (i == n) {
				i = n - 1;
			}
			j--;
			if (j < 0) {
				break;
			}
			if (data[i][j] == x) {
				return true;
			} else if (data[i][j] < x) {
				continue;
			}

		}
		return false;
	}

	public static boolean sort2(int[][] data,int n,int m,int x) {
		int hang = 0,lie = m-1;
		while(hang < n && lie >= 0) {
			if(data[hang][lie]==x ) {
				return true;
			}else if(data[hang][lie] > x) {
					lie --;
			}else {
				hang ++;
			}
		}
		return false;
	}
}
