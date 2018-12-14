package algo.day02;

/**
 * ��֪һ��������������飬����������ֵ�� ����������ź�˳��Ļ���ÿ��Ԫ���ƶ��ľ��벻����K�� ����K��������鳤����˵��С��
 * ����ѡ��ʲô������������ȽϺá��Ľ���Ķ����� ˼·������������ôð�ݡ�ѡ��Ͳ����ˣ�������һ����O(N2)
 * ��������ÿ�κ�ǰ�����������Ƚϣ�������ԣ�ʱ�临�Ӷ�ΪO��N*K)
 * ��������O��N*logN)��ѡ��Ļ����йأ�ϣ�����򣬸��ݲ����Ƚϣ����У��鲢����Ҳ���ܳ�������������Ƿֳ�һ��Ԫ�أ�Ȼ��ϲ���������
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoOne {
/**
 * ����������С���ǲ��е�
 * @param data
 * @param n
 * @param k
 */
	public static void sortElement(int[] data, int n, int k) {
		int[] aux = new int[k];
		// ����һ��С���ѣ���aux�������
		for (int i = 0; i < k; i++) {
			up(aux, data[i], i);
		}

		for (int i = 0; i < n - k; i++) {
			data[i] = aux[0];// ÿ��ȡ����Сֵ�����k��Ԫ��
			System.out.print(aux[0] +"\t");
			down(aux, data[i + k], 0);
		}
		System.out.println();
		for (int m = 1; m < aux.length; m++) {
			int value = aux[m];//����������
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
