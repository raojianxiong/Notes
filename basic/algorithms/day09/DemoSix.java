package algo.day09;

import java.util.Random;

/**
 * ����һ������ΪN��û���ظ�Ԫ�ص�����arr��һ������M
 * ʵ�ֺ����ȸ��������ӡarr�е�M������
 * @author Jianxiong Rao
 *
 */
public class DemoSix {

	public static void printRandom(int[] arr,int M) {
		if(arr == null) {
			System.out.println("arr == null");
			return;
		}
		int n = arr.length;
		Random random = new Random();
		while(M> 0) {
			M --;

			int index = random.nextInt(n--);
			System.out.println("DemoSix -> "+arr[index]);
			int temp = arr[n];
			arr[n] = arr[index];
			arr[index] = temp;
		}
	}
}
