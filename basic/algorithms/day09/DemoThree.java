package algo.day09;

import java.util.Random;

/**
 * ����һ���ȸ����������1~5���������������֮�⣬ 
 * ����ʹ���κζ����������ƣ���ʵ�ֵȸ����������1 ~ 7�����������
 * ����һ���ɵ��õ�Random5::random()���������Եȸ��ʲ���1~5���������
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoThree {

	public static int randomNumber() {
		// 1 ~ 5
		// 0 ~ 24 
		int a = 5 * (rand5() - 1) + rand5() - 1;
		while( a > 20) {
			a = 5 * (rand5() - 1) + rand5() -1;
		}
		return a %7 + 1;
	}
	/**
	 * �������1~5
	 * @return
	 */
	private static int rand5() {
		return new Random().nextInt(5)+1;
	}
}
