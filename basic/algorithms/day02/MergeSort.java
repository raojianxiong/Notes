package algo.day02;

/**
 * �鲢����
 * 
 * @author Jianxiong Rao
 *
 */
public class MergeSort {

	/**
	 * �Զ����� �ȷֳ�һ��һ�� O��NlogN)
	 * 
	 * @param data
	 * @return
	 */
	public static int[] sort(int[] data) {
		if (data == null)
			return null;
		int left = 0;
		int right = data.length - 1;
		mergeSort(data, left, right);
		return data;
	}

	/**
	 * �Ե�����
	 * @param data
	 * @return
	 */
	public static int[] sortFormBootm(int[] data) {
		if (data == null)
			return null;
		//����������ò�������
		for(int i=0;i<data.length -1;i+=20) {
			insertSort(data, i, Math.min(i+19, data.length -1));
		}
		int n = data.length-1;
		for (int sz = 1; sz <= n; sz += sz) {//���� ��һ�ϲ�
			for(int i =0;i<n-sz;i+=sz+sz) {
				if(data[i+sz-1] > data[i+sz]) {
					merge(data, i, i+sz-1, Math.min(i+2*sz-1,n-1));
				}
			}
		}
		return data;
	}

	private static void mergeSort(int[] data, int left, int right) {
		int mid = (right - left+1) / 2;
		// �����߽��в��
		mergeSort(data, left, mid);
		mergeSort(data, mid + 1, right);
		// �ϲ�
		if (data[mid] > data[mid + 1]) {// ���ϲ�ʱ�����һ�������ڵ�һ����ʱ����Ҫ����
			merge(data, left, mid, right);
		}
	}

	private static void merge(int[] data, int left, int mid, int right) {
		// �ܹ��� right - left + 1 ��Ԫ��
		int[] aux = new int[right - left + 1];
		for (int i = left; i <= right; i++) {
			aux[i - left] = data[i];
		}
		int i = left, j = mid + 1;
		for (int k = left; k <= right; k++) {
			if (i > mid) {
				// left ���û��������
				data[k] = aux[j - left];
				++j;
			} else if (j > right) {
				// right ���û��������
				data[k] = aux[i - left];
				++i;
			} else if (aux[i - left] < aux[j - left]) {
				data[k] = aux[i - left];
				++i;
			} else {
				data[k] = aux[j - left];
				++j;
			}
		}
	}
	private static void insertSort(int[] data,int left,int right) {
		if(right< left) return;
		for(int i = left;i <= right;i++) {
			int value = data[i + 1];
			int j = i+1;
			for(;j>=0 && value < data[j-1];--j) {
				data[j] = data[j-1];
			}
			data[j] = value;
		}
	}

}
