package algo.day09;

import java.util.Random;

/**
 * ����һ����p���ʲ���0����1-p���ʲ���1���������f(),p�ǹ̶�ֵ��
 * ���㲢��֪���Ƕ��٣�
 * ����֮��Ҳ����ʹ���κζ����������ƣ�����f()ʵ�ֵȸ����������0��1���������
 * ����01��10�ĸ�������ȵġ�
 * @author Jianxiong Rao
 *
 */
public class DemoFour {

	public static int random() {
		int a ,b;
		while(true) {
			
			a = f();
			b = f();
			if(a != b) {
				return a> b?0:1;
			}
		}
	}
	private static int f() {
		return new Random().nextInt(1);
	}
}
