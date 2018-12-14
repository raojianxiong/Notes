package algo.day02;
/**
 * ��õ������ֻ�Ƚ�һ��,ʱ�临�Ӷ�ΪO(n)
 * ��������ȫ�Ƚ� O(n2)
 * ƽ��ʱ�临�Ӷ�O��n2) 
 *    ---->>>> ����� i< j ,a[i] > a[j]
 *    ---->>>> ����� i>j ,a[i] < a[j]
 *    ---->>>> ������� C n 2 -> n*(n-1)/2
 *    ---->>>> ��������Ϊ0 ��ô�ȽϺ󣬽�������λn*(n-1)/2
 *    ---->>>> ȡ�м�ֵ ,��ʼ����� n*(n-1)/4,��ô����Ҫ���� n*(n-1)/4,���Ƚϲ����϶��Ƚ�������������
 * @author Jianxiong Rao
 *
 */
public class BubbleSort {
	public static int[] sort(int[] data) {
		if(data == null) return null;
		for(int i =0;i<data.length;i++) {
			for(int j=0;j<data.length - 1-i;j++) {
				if(data[j] > data[j+1] ) {
					int temp = data[j];
					data[j]= data[j+1];
					data[j+1] = temp;
				}
			}
		}
		return data;
	}
	public static int[] optimizeSort(int[] data) {
		if(data ==null) return null;
		for(int i = 0;i< data.length-1;i++) {
			boolean isSorted = false;
			for(int j = 0;j<data.length - 1 -i;j++) {
				if(data[j]> data[j+1] ) {
					int temp = data[j];
					data[j]= data[j+1] ;
					data[j+1] = temp;
					isSorted = true;
				}
			}
			if(!isSorted) {
				//��������ֲ�û�����ݽ��н�����˵����Ϊ����������
				//Ҫ������������
				break;
			}
		}
		return data;
	}
}
