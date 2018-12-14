package algo.day02;

/**
 * ����һ�����飬�����һ����У���㷨������Ҫ��������������ĳ���
 * int����A �����Сn
 * ����һ����Ԫ�飬�����������еĳ���
 * [1,4,6,5,9,10]
 * @author Jianxiong Rao
 *
 */
public class DemoSix {
	public static void sort(int[] data,int n) {
		int max= data[0],maxIndex = 0;
		int min = data[n-1],minIndex= n-1;
		for(int i=0;i<n;i++) {
			if(data[i] >max) {
				max = data[i];
			}else {
				maxIndex = i;
			}
			if(data[n-1-i]<min ) {
				min  = data[n-1-i];
			}else {
				minIndex = n-1-i;
			}
		}
		if(maxIndex == 0) {
			System.out.println("�����");
			return;
		}
		System.out.println("���� -> "+(maxIndex - minIndex+ 1));
	}
}
