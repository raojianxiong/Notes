package algo.day05;
/**
 * 有一个有序数组arr,其中不含有重复元素，请找到满足arr[i] == i条件的最左的位置，
 * 如果所有位置上的数都不满足条件，返回-1.给定有序数组arr及它的大小n，
 * 请返回所求值。[-1,0,2,3],4 返回 2 
 * @author Jianxiong Rao
 *
 */
public class DemoFour {

	public static int checkMin(int[] data,int n) {
		if(data==null ) {
			return -1;
		}
		if(data[0] >n-1 ||data[n-1] < 0) {
			return -1;
		}
		int low = 0;
		int high = n-1;
		int mid ;
		int res = -1;
		while(low <= high) {
			mid = low + (high - low) /2;
			if(data[mid] > mid) {
				high = mid -1;
			}else if(data[mid] < mid) {
				low = mid+1;
			}else {
				res =  mid; 
				high = mid -1;
				
			}
		}
		return res;
			
	}
}
