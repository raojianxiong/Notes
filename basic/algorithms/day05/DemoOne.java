package algo.day05;
/**
 * ����ֲ���С�ĸ��arr����Ϊ1ʱ��arr[0]�Ǿֲ���С��arr�ĳ���ΪN(N>1)ʱ�����arr[0]<arr[1],��ôarr[0]�Ǿֲ���С��
 * ���arr[N-1]<arr[N-2]����ôarr[N-1]�Ǿֲ���С�ģ����0<i<N-1,����arr[i]<arr[i-1]����arr[i]<arr[i+1],��ôarr[i]�Ǿֲ���С��
 * ������������arr��
 * ��֪arr�������������ڵ���������ȣ�дһ��������ֻ�践��arr������һ���ֲ���С���ֵ�λ�ü���
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
