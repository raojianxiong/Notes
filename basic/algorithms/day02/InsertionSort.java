package algo.day02;

/**
 * 最好情况 O(n) 最坏情况O(n2) 平均时间复杂度O（n 2)
 * 
 * @author Jianxiong Rao
 *
 */
public class InsertionSort {

	public static int[] sort(int[] data) {
		if (data == null)
			return null;
		// 向有序数组内插入数据
		for (int i = 1; i < data.length; i++) {
			int value = data[i];// 要插入的值
			int j = i - 1;
			for (; j >= 0; --j) {
				if (value < data[j]) {
					data[j + 1] = data[j];
				} else {
					break;
				}
			}
			data[j + 1] = value;

		}
		return data;
	}

	/**
	 * 希尔排序
	 * 
	 * @param data
	 * @return
	 */
	public static int[] heerSort(int[] data) {
		if (data == null)
			return null;
		int h = 1;// 步长
		int n = data.length;
		while (h < n / 3) {
			h = 3 * h + 1;
		}
		// 0...h-1 // h ....2h-1...
		while (h >= 1) {
			for (int i = h; i < n; i++) {
				int index;
				int e = data[i];
				for (index = i; index >= h && e < data[index - h]; index -= h) {
					// 交换
					data[index] = data[index - h];
				}
				data[index] = e;
			}

			h /= 3;
		}
		return data;
	}
}
