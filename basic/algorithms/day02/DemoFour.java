package algo.day02;

/**
 * ��һ��ֻ�� 0
 * ��1��2����Ԫ�ع��ɵ��������飬
 * ��ʹ�ý�����ԭ�����������ʹ�ü����������򡣸���һ��ֻ��0��1��2����������A�����Ĵ�С��
 * �뷵�����������顣��֤�����СС�ڵ���500��
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoFour {

	public static void sort(int[] data,int n) {
		int lt = 0,gt = n;// [left...lt] < value ,[lt+1....gt] = value ,[gt+1... n-1] > value
		int value = 1;
		int i = 0;
		while(i < gt) {
			if(data[i] < value) {
				int temp = data[i];
				data[i]= data[lt];
				data[lt] = temp;
				i++;
				lt ++;
			}else if(data[i]> value ) {
				int temp = data[i];
				data[i]= data[gt -1];
				data[gt-1] = temp;
				gt --;
			}else {
				i++;
			}
		}
		
		for(int result:data) {
			System.out.print(result + "\t");
		}
	}
}
