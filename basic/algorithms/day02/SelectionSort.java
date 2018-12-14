package algo.day02;
/**
 * ������O(n2)
 * ����O(n2)
 * ���ȶ�����ÿ��ѡ�����Ԫ�ص���Сֵ���н���
 * @author Jianxiong Rao
 *
 */
public class SelectionSort {
	public static int[] sort(int[] data) {
		if(data == null) return null;
		
		for(int i = 0;i<data.length;i++) {
			int mim = i;
			for(int j= mim +1;j<data.length;j++) {
				if(data[mim] >data[j] ) {
					mim = j;
				}
			}
			if(mim != i) {
				int temp = data[i];
				data[i]= data[mim];
				data[mim]= temp; 
			}
		}
		return data;
	}
}
