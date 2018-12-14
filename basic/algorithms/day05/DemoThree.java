package algo.day05;
/**
 * 对于一个有序循环数组arr，请返回arr中最小值。
 * 有序循环数组是指，有序数组左边任意长度的部分放到右边去，
 * 右边的部分拿到左边来。比如[1,2,3,4],是有序循环数组,[4,1,2,3,3]页时。
 * 给定数组arr及它的大小n，
 * 请返回最小值。[4,1,2,3,3], 5 返回 1 。
 * @author Jianxiong Rao
 *
 */
public class DemoThree {

	/**
	 * 方法一:既然是有序的，那么就直接遍历，如果有data[i] > data[i+1] , data[i] < data[i-1],i+1就是最小的位置
	 * 如果找了一遍没有这样的数，那么直接返回data[0]
	 *  O(N)
	 *  方法二:O(logN)
	 * @param data
	 * @param n
	 * @return
	 */
	public static int getMin(int[] data,int n) {
		if(data == null) {
			return -1;
		}
		if(n == 1) {
			return data[0];
		}
		int low = 0;
		int high = n -1;
		int mid;
		while(low <high) {//mid-1/mid +1 可以使用==号哦
			mid = low + (high - low) >> 1;
			if(data[low] > data[mid]) {
				high = mid;  
			}else if(data[high] < data[mid]) {
				low = mid + 1;
			}else {
				// 2 2 3 3 3 3 4 6 6  data[mid] 为 3
				// 2 2 2 2 1 1 1 2 2 2 2  data[low] = data[mid] = data[high]
				break;
			}
			
		}
		
		int min = data[low];
		while(low <= high) {
			if(data[low] < min) {
				min = data[low];
			}
			low ++;
		}
		return min;
	}
}
