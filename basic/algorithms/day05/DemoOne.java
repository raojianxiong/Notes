package algo.day05;
/**
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，如果arr[0]<arr[1],那么arr[0]是局部最小；
 * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小的，如果0<i<N-1,既有arr[i]<arr[i-1]又有arr[i]<arr[i+1],那么arr[i]是局部最小。
 * 给定无序数组arr，
 * 已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可
 * @author Jianxiong Rao
 *
 */
public class DemoOne {


	public static int checkMin(int[] data) {
		if(data == null) {
			return -1;
		}
		if(data.length < 2) {
			return 0;
		}
		if(data[0] < data[1]) {
			return 0;
		}
		if(data[data.length -1] < data[data.length -2 ]) {
			return data.length - 1;
		}
		int mid = 0;
		int left = 1;
		int right = data.length - 2;
		while(left < right) {
			mid = left + (right - left)/2;
			if(data[mid]<data[mid-1] && data[mid] < data[mid +1] ) {
				return mid;
			}
			if(data[mid] >data[mid -1]) {
				right = mid -1;
			}
			if(data[mid] > data[mid +1]) {
				left = mid + 1 ;
			}
		}
		return -1;
		
	}
	
}
