package algo.day02;

/**
 * ������ O(n) ����O(n2) ƽ��ʱ�临�Ӷ�O��n 2)
 * 
 * @author Jianxiong Rao
 *
 */
public class InsertionSort {

	public static int[] sort(int[] data) {
		if (data == null)
			return null;
		// �����������ڲ�������
		for (int i = 1; i < data.length; i++) {
			int value = data[i];// Ҫ�����ֵ
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
	 * ϣ������
	 * 
	 * @param data
	 * @return
	 */
	public static int[] heerSort(int[] data) {
		if (data == null)
			return null;
		int h = 1;// ����
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
					// ����
					data[index] = data[index - h];
				}
				data[index] = e;
			}

			h /= 3;
		}
		return data;
	}
}
