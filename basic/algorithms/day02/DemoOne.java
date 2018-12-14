package algo.day02;

/**
 * 已知一个几乎有序的数组，几乎有序是值， 如果把数组排好顺序的话，每个元素移动的距离不超过K， 并且K相对于数组长度来说很小。
 * 请问选择什么方法对其排序比较好。改进后的堆排序 思路：几乎有序，那么冒泡、选择就不行了，这两个一定是O(N2)
 * 插入排序，每次和前面的有序数组比较，这个可以，时间复杂度为O（N*K)
 * 快速排序，O（N*logN)跟选择的基点有关，希尔排序，根据步长比较，不行，归并排序也不能充分利用有序，它是分成一个元素，然后合并。堆排序
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoOne {
/**
 * 按常理构建最小堆是不行的
 * @param data
 * @param n
 * @param k
 */
	public static void sortElement(int[] data, int n, int k) {
		int[] aux = new int[k];
		// 建立一个小根堆，由aux数组组成
		for (int i = 0; i < k; i++) {
			up(aux, data[i], i);
		}

		for (int i = 0; i < n - k; i++) {
			data[i] = aux[0];// 每次取出最小值，最后k个元素
			System.out.print(aux[0] +"\t");
			down(aux, data[i + k], 0);
		}
		System.out.println();
		for (int m = 1; m < aux.length; m++) {
			int value = aux[m];//待插入数据
			int j = m;
			for (; j >=0 && aux[j-1] > value; --j) {
				aux[j] = aux[j-1];
			}
			aux[j] = value;
		}
		
		for (int i = n - k; i < n; i++) {
			data[i] = aux[i-n+ k];

		}
		System.out.println();
		for (int i : data) {
			System.out.print(i + "\t");
		}

	}

	private static void up(int[] data, int element, int k) {
		data[k] = element;
		while (k > 0 && data[k] < data[(k - 1) / 2]) {
			int temp = data[k];
			data[k] = data[(k - 1) / 2];
			data[(k - 1) / 2] = temp;
			k = (k - 1) / 2;
		}

	}

	private static void down(int[] data, int element, int k) {
		data[k] = element;
		while ((2 * k + 1) <= (data.length - 1)) {
			int j = 2 * k + 1;
			if (j + 1 <= data.length - 1 && data[j] > data[j + 1]) {
				j++;
			}
			if (element <= data[j])
				break;
			data[k] = data[j];
			k = j;
		}
		data[k] = element;
	}

}
