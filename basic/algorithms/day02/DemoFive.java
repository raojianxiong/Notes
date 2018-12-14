package algo.day02;

/**
 * 现在有一个行和列都排好序的矩阵， 请设计一个高效算法，快速找到矩阵中是否含有值x
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoFive {
	/**
	 * n行m列 每行每列都是从小到大的有序数组
	 * 第二种简单 O（M+N)
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
