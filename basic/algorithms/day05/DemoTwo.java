package algo.day05;

/**
 * 对于一个有序数组arr,再给定一个整数num,
 * 请在arr中找到这个数出现的最左边的位置。给定一个数组arr以及它的大小n,同时给定num，
 * 请返回所求位置，若该元素在数组中未出现，请返回-1。[1,2,3,4],5,3 返回 2
 * @author Jianxiong Rao
 *
 */
public class DemoTwo {

	public static int checkMin(int[] data, int n, int num) {
		if (data == null) {
			return -1;
		}
		int left = 0;
		int right = n - 1;
		int mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (data[mid] > num) {
				right = mid - 1;
			} else if (data[mid] < num) {
				left = mid + 1;
			} else {
				if (mid == 0 || data[mid - 1] != num) {
					return mid;
				}else {
					right = mid -1;
				}
			}
		}
		return -1;
	}
}
