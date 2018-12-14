package algo.day09;

import java.util.Random;

/**
 * 给定一个长度为N且没有重复元素的数组arr和一个整数M
 * 实现函数等概率随机打印arr中的M个数。
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
