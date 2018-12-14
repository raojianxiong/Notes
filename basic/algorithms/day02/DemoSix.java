package algo.day02;

/**
 * 对于一个数组，请设计一个高校的算法计算需要排序的最短子数组的长度
 * int数组A 数组大小n
 * 返回一个二元组，代表所求序列的长度
 * [1,4,6,5,9,10]
 * @author Jianxiong Rao
 *
 */
public class DemoSix {
	public static void sort(int[] data,int n) {
		int max= data[0],maxIndex = 0;
		int min = data[n-1],minIndex= n-1;
		for(int i=0;i<n;i++) {
			if(data[i] >max) {
				max = data[i];
			}else {
				maxIndex = i;
			}
			if(data[n-1-i]<min ) {
				min  = data[n-1-i];
			}else {
				minIndex = n-1-i;
			}
		}
		if(maxIndex == 0) {
			System.out.println("有序的");
			return;
		}
		System.out.println("长度 -> "+(maxIndex - minIndex+ 1));
	}
}
