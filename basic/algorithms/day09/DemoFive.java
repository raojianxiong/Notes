package algo.day09;

import java.util.Random;

/**
 * ���躯��f()�ȸ����������һ����[0,1)��Χ�ϵĸ���������ô����֪����
 * ��[0,x)�����ϵ������ֵĸ���Ϊx(0<x<=1)��
 * ����һ������0������k,���ҿ���ʹ��f()������
 * ��ʵ��һ��������Ȼ������[0,1)��Χ�ϵ�����������[0,x)�����ϵ������ֵĸ���Ϊx��k�η���
 * @author Jianxiong Rao
 *
 */
public class DemoFive {

	public static double random(int k) {
		double result = -1D;
		while(k> 0) {
			k --;
			double b = f();
			result = (result > b) ? result:b;
		}
		return result;
	}
	/**
	 * ���������0 - 1 ��Χ�ĸ�����
	 * @return
	 */
	private static double f() {
		return new Random(1).nextDouble();
	}
}
