package algo.day02;

/**
 * ������ O��NlogN) ���� �ӽڵ��ֵһ��С�ڸ��ڵ�
 * 
 * @author Jianxiong Rao
 *
 */
public class HeapSort {
	private int[] data;//����� 1 �±꿪ʼ�����ݡ�k �ӽڵ� Ϊ 2k 2k+1 ,�����0��ʼ���ӽڵ�Ϊ 2k+1,2k+2
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
	 * �����k���ڵ� logN
	 * 
	 * @param k
	 */
	private void shiftUp(int k) {
		while (k > 1 && data[k / 2] < data[k]) {// ���ڵ� ֵ С�� �ӽڵ� ����Ҫ����
			int temp = data[k];
			data[k] = data[k / 2];
			data[k / 2] = temp;
			k = k / 2;
		}
	}

	private void shiftDown(int k) {
		int value = data[k];
		while (2 * k <= count) {// ���ڵ�Ϊk,���Ӻ���Ϊ 2*k
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

			k = j;// ������������
		}
		data[k] = value;
	}

}
