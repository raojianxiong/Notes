package algo.day05;

/**
 * ����һ����������arr,�ٸ���һ������num,
 * ����arr���ҵ���������ֵ�����ߵ�λ�á�����һ������arr�Լ����Ĵ�Сn,ͬʱ����num��
 * �뷵������λ�ã�����Ԫ����������δ���֣��뷵��-1��[1,2,3,4],5,3 ���� 2
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
