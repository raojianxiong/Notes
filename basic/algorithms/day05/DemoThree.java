package algo.day05;
/**
 * ����һ������ѭ������arr���뷵��arr����Сֵ��
 * ����ѭ��������ָ����������������ⳤ�ȵĲ��ַŵ��ұ�ȥ��
 * �ұߵĲ����õ������������[1,2,3,4],������ѭ������,[4,1,2,3,3]ҳʱ��
 * ��������arr�����Ĵ�Сn��
 * �뷵����Сֵ��[4,1,2,3,3], 5 ���� 1 ��
 * @author Jianxiong Rao
 *
 */
public class DemoThree {

	/**
	 * ����һ:��Ȼ������ģ���ô��ֱ�ӱ����������data[i] > data[i+1] , data[i] < data[i-1],i+1������С��λ��
	 * �������һ��û��������������ôֱ�ӷ���data[0]
	 *  O(N)
	 *  ������:O(logN)
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
		while(low <high) {//mid-1/mid +1 ����ʹ��==��Ŷ
			mid = low + (high - low) >> 1;
			if(data[low] > data[mid]) {
				high = mid;  
			}else if(data[high] < data[mid]) {
				low = mid + 1;
			}else {
				// 2 2 3 3 3 3 4 6 6  data[mid] Ϊ 3
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
