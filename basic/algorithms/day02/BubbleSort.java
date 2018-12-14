package algo.day02;
/**
 * 最好的情况是只比较一次,时间复杂度为O(n)
 * 最坏情况就是全比较 O(n2)
 * 平均时间复杂度O（n2) 
 *    ---->>>> 有序度 i< j ,a[i] > a[j]
 *    ---->>>> 逆序度 i>j ,a[i] < a[j]
 *    ---->>>> 满有序度 C n 2 -> n*(n-1)/2
 *    ---->>>> 如果有序度为0 那么比较后，交换操作位n*(n-1)/2
 *    ---->>>> 取中间值 ,初始有序度 n*(n-1)/4,那么就需要交换 n*(n-1)/4,而比较操作肯定比交换操作次数多
 * @author Jianxiong Rao
 *
 */
public class BubbleSort {
	public static int[] sort(int[] data) {
		if(data == null) return null;
		for(int i =0;i<data.length;i++) {
			for(int j=0;j<data.length - 1-i;j++) {
				if(data[j] > data[j+1] ) {
					int temp = data[j];
					data[j]= data[j+1];
					data[j+1] = temp;
				}
			}
		}
		return data;
	}
	public static int[] optimizeSort(int[] data) {
		if(data ==null) return null;
		for(int i = 0;i< data.length-1;i++) {
			boolean isSorted = false;
			for(int j = 0;j<data.length - 1 -i;j++) {
				if(data[j]> data[j+1] ) {
					int temp = data[j];
					data[j]= data[j+1] ;
					data[j+1] = temp;
					isSorted = true;
				}
			}
			if(!isSorted) {
				//如果排序发现并没有数据进行交换，说明此为有序数据了
				//要考虑有序数据
				break;
			}
		}
		return data;
	}
}
