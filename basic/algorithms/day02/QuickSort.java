package algo.day02;

import java.util.Random;

/**
 * 快速排序
 * 空间复杂度O（logn -n) 递归调用栈
 * 
 * @author Jianxiong Rao
 *
 */
public class QuickSort {
	public static int[] sort(int[] data) {
		if (data == null)
			return null;
		quickSort(data, 0, data.length - 1);
//		parition3(data,0,data.length -1);
		return data;
	}

	private static void quickSort(int[] data, int left, int right) {
		if (left >= right)
			return;
		int pos = parition(data, left, right);
		quickSort(data, left, pos - 1);
		quickSort(data, pos + 1, right);

	}

	private static int parition(int[] data, int left, int right) {
		int index = new Random().nextInt((right - left + 1));
		int value = data[index + left];// 随机选一个作为基准数
		data[index + left] = data[left];
		data[left] = value;
//		int value = data[left];
		int j = left;
		for (int i = left + 1; i <= right; i++) {
			if (data[i] < value) {
				data[j] = data[i];
				++j;
				data[i] = data[j];
				// data[j] = value;
			}
		}
		data[j] = value;
		return j;

	}

	private static int parition2(int[] data, int left, int right) {
		int number = right - left;
		int index = new Random().nextInt(number);
		int value = data[left + index];// 随机选一个作为基准数
		data[index + left] = data[left];
		data[left] = value;
		int i = left + 1;
		int j = right;
		while (i < j) {
			while (i <= j && data[i] <= value) {
				i++;
			}
//			data[j] = data[i];
			while (i <= j && data[j] >= value) {
				j--;
			}
//			data[i] = data[j];
			if (i > j)
				break;
			int temp = data[i];
			data[i] = data[j];
			data[j] = temp;
			i++;
			j--;
		}
		data[left] = data[j];
		data[j] = value;
//		data[i] = value;
		return j;

	}

	private static void parition3(int[] data, int left, int right) {
		if(left>= right) return;
		// if(right - left <= 15) {
		// 插入排序
		// }
		int number = right - left;
		int index = new Random().nextInt(number);
		int value = data[left + index];// 随机选一个作为基准数
		data[index + left] = data[left];
		data[left] = value;
//		int value = data[left];
		int lt = left; // data[ left + 1 ... lt] < v
		int gt = right + 1;// data[gt ... right] > v
		int i = left + 1; // data[lt+ 1 ... i] == v
		while (i < gt) {
			if (data[i] < value) {
				int temp = data[lt + 1];
				data[lt + 1] = data[i];
				data[i] = temp;
				i++;
				lt++;
			} else if (data[i] > value) {
				int temp = data[gt - 1];
				data[gt - 1] = data[i];
				data[i] = temp;
				gt--;

			} else {
				i++;
			}
		}
		data[left] = data[lt];
		data[lt] = value;
		parition3(data, left, lt - 1);
		parition3(data, gt, right);
	}
}
