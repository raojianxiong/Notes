package algo.day10;

public class DemoOne {

	/**
	 * ����һ �����ƽ�
	 * 
	 * @param arr
	 * @param aim
	 * @return
	 */
	public static int coinsl(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		return process1(arr, 0, aim);
	}

	/**
	 * ������ �����ƽⷨ
	 * 
	 * @param arr ����
	 * @param aim ��������
	 * @return
	 */
	public static int coinsl2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] map = new int[arr.length + 1][aim + 1];
		return process2(arr, 0, aim, map);
	}

	/**
	 * ��̬�滮 map[i][j]�ĺ�������ʹ��arr[0........i]������£����Ǯ�� j �ж����ַ���
	 * 
	 * @param data -> ����
	 * @param n
	 * @param aim
	 * @return
	 */
	private static int coinsl3(int[] data, int n, int aim) {
		if (data == null || data.length == 0 || aim < 0) {
			return 0;
		}
		int[][] map = new int[n][aim + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < aim + 1; j++) {
				map[i][j] = -1;
			}
		}
		// Ǯ��Ϊ0�������������ֵǮ������1��
		for (int i = 0; i < n; i++) {
			map[i][0] = 1;
		}
		// data[0]�Ļ�����ֻ��ʹ��data[0]��һ�ֻ��ң������ܱ������ľ�����
		for (int i = 0; i < aim+1; i++) {
			if (i % data[0] == 0) {
				map[0][i] = 1;
			} else {
				map[0][i] = 0;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < aim + 1; j++) {
				if (j - data[i] >= 0) {
					map[i][j] = map[i][j - data[i]] + map[i - 1][j];
				} else {
					// Ǯ���ȵ�ǰdata[i]С,
					map[i][j] = map[i - 1][j];
				}
			}
		}
		return map[n - 1][aim];
	}

	private static int process2(int[] arr, int index, int aim, int[][] map) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;
		} else {
			int mapValue = 0;
			for (int i = 0; arr[index] * i <= aim; i++) {
				mapValue = map[index + 1][aim - arr[index] * i];
				if (mapValue != 0) {
					res += mapValue == -1 ? 0 : mapValue;
				} else {
					res += process2(arr, index + 1, aim - arr[index] * i, map);
				}
			}
		}
		map[index][aim] = res == 0 ? -1 : res;
		return res;
	}

	private static int process1(int[] arr, int index, int aim) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;
		} else {
			for (int i = 0; arr[index] * i <= aim; i++) {
				res += process1(arr, index + 1, aim - arr[index] * i);
			}
		}
		return res;
	}
}
