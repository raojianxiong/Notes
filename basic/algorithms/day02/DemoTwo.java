package algo.day02;

/**
 * �ж��������Ƿ����ظ�ֵ�����뱣֤����ռ临�Ӷ�ΪO(1)���ǵݹ�Ķ�����
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoTwo {

	public static boolean sort(int[] data, int n) {
		if (data == null || n < 2) {
			return false;
		}
		// ��ʼ�������
//		for (int i = 0; i <n;i++) {
//			 up(data, i, n); //�����Ƿ�Ԫ�أ�Ȼ�����ع���
//			//down(data, i, n);
//		}
		for(int i=n/2-1;i>=0;i--){
			down(data, i, n);
		}
		for (int i : data) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for (int i = n - 1; i > 0; i--) {
			if (data[0] != data[i]) {
				int temp = data[0];
				data[0] = data[i];
				data[i] = temp;
			}
			down(data, 0, i );
		}
		for (int i : data) {
			System.out.print(i + "\t");
		}
		for (int i = 1; i < n; i++) {
			if (data[i - 1] == data[i]) {
				return true;
			}
		}
		return false;

	}

	/**
	 * 
	 * @param data ����Ԫ��
	 * @param k    Ԫ�ص��±�
	 * @param n    �����ѵĴ�С
	 */
	private static void up(int[] data, int k, int n) {
		int add = data[k];
		while (k > 0 && data[k] > data[(k - 1) / 2]) {// �ӽڵ���ڸ��ڵ�
			int temp = data[k];
			data[(k - 1) / 2] = data[k];
			data[k] = temp;
			k = (k - 1) / 2;
		}
		data[k] = add;
	}

	/**
	 * ������
	 * 
	 * @param data
	 * @param start
	 * @param end
	 */
	private static void down(int[] data, int k, int n) {
		int value = data[k];
		while (2 * k + 1 < n) {
			int j = 2 * k + 1;
			if (j + 1 < n && data[j] < data[j + 1]) {
				++j;
			}
			if (value >= data[j])
				break;
			data[k] = data[j];
			k = j;
		}
		data[k] = value;
	}

	public static void buildHeap(int[] a, int start, int end) {
		int child = start * 2 + 1;
		// ����ѭ���ж� ���õݹ�
		while (child < end) {
			if (a[child + 1] > a[child] && (child + 1) <= end)
				child = child + 1;
			if (a[child] < a[start]) {
				break;
			} else {
				change(a, start, child);
			}
			start = child;
			child = 2 * start + 1;
		}
	}

	public static void change(int[] tem, int a, int b) {
		if (a != b) {
			int temm = tem[a];
			tem[a] = tem[b];
			tem[b] = temm;
		}
	}

}
