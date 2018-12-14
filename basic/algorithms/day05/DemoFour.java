package algo.day05;
/**
 * ��һ����������arr,���в������ظ�Ԫ�أ����ҵ�����arr[i] == i�����������λ�ã�
 * �������λ���ϵ���������������������-1.������������arr�����Ĵ�Сn��
 * �뷵������ֵ��[-1,0,2,3],4 ���� 2 
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
