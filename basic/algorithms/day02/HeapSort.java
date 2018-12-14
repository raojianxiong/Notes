package algo.day02;

/**
 * 堆排序 O（NlogN) 最大堆 子节点的值一定小于父节点
 * 
 * @author Jianxiong Rao
 *
 */
public class HeapSort {
	private int[] data;//数组从 1 下标开始存数据。k 子节点 为 2k 2k+1 ,如果从0开始，子节点为 2k+1,2k+2
	private int count;
	private int capacity;

	public HeapSort(int capacity) {
		data = new int[capacity];
		count = 0;
		this.capacity = capacity;

	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void insert(int a) {
		if (count > capacity)
			return;
		data[count + 1] = a;
		shiftUp(count + 1);
		count++;
	}

	public int extractMax() {
		int result = data[1];
		data[1] = data[count];
		data[count] = 0;
		count--;
		shiftDown(1);
		return result;
	}
	

	/**
	 * 插入第k个节点 logN
	 * 
	 * @param k
	 */
	private void shiftUp(int k) {
		while (k > 1 && data[k / 2] < data[k]) {// 父节点 值 小于 子节点 就需要交换
			int temp = data[k];
			data[k] = data[k / 2];
			data[k / 2] = temp;
			k = k / 2;
		}
	}

	private void shiftDown(int k) {
		int value = data[k];
		while (2 * k <= count) {// 父节点为k,左子孩子为 2*k
			int j = 2 * k;
			if (j + 1 <= count && data[j] < data[j + 1]) {
				j++;
			}
			if (value >= data[j]) {
				break;
			}
			//int temp = data[j];
			//data[j] = data[k];
			data[k] = data[j];

			k = j;// 继续深入树内
		}
		data[k] = value;
	}

}
