package algo.day11;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * ��Ϊһ���������ˣ���Ҫ�������nƥ�����һ������nƥ�������
 * ���Ѿ�֪���˶Է����ĳ�վ�����μ�ÿһ�������ǿ׳�̶ȡ�
 * ��Ȼ��Ҳ֪�����Լ����������ǿ׳�ȡ����Ǽٶ������Ľ��ֱ�������ǿ׳�Ⱦ�����
 * ����׳�����ʤ������ͬ��˫�������ʤ��,�������һ�����ԣ�
 * ʹ���ܻ�þ�����ĳ��ε�ʤ����
 * �����Է�ÿ�����������ǿ׳�̶�oppo������������ǿ׳�̶�horses(ǿ׳�̶�Ϊ����,������Խ��Խǿ׳)��
 * ͬʱ����n,�뷵������ܻ�ʤ�ĳ��Ρ�����������[1,2,3]
 * , [1,2,3] , 3 ���� 2
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoTwo {
	public static void main(String[] args) {
		int data = winMost(new int[] {1,2,3}, new int[] {1,2,3},3);
		System.out.println("Win Most -> "+ data);
	}
	public static int winMost(int[] oppo,int[] horses,int n) {
		//���ȶ��������������ҵ��ҷ������һ���ȶԷ�0λ�ô���� ���ߴ�β����ǰ
		Arrays.sort(horses);
		Arrays.sort(oppo);
		int right = n-1,num = 0;
		for(int i = n-1;i>=0;i--) {
			if(horses[right] > oppo[i]) {
				right --;
				num ++;
			}
		}
//		int oppoIndex = 0;
//		int horsesIndex = 0;
//		while(true) {
//			if(oppoIndex == n || horsesIndex == n) {
//				break;
//			}
//			if(horses[horsesIndex ]>oppo[oppoIndex ] ) {
//				horsesIndex ++;
//				oppoIndex ++;
//				num ++;
//			}else {
//				horsesIndex ++;
//			}
//		}
		
		return num;
	}

}
