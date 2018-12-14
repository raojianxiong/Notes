package algo.day09;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import jdk.dynalink.beans.StaticClass;

/**
 * ��һ����������Ȼ�����еķ�ʽ�³���1����2����3����ȵȡ�
 * ����һ�����ӣ����������ֻ��װ��K����
 * ���ҳ��������⣬��û�и���Ŀռ䣬һ����һ���ӵ�������Ҳ�����ûء�
 * ���һ��ѡ��ʽ��ʹ�õ������³���N�����ʱ��������е�������K����
 * ͬʱ���Ա�֤��1����N�����е�ÿһ������ѡ�����ӵĸ��ʶ���K/N��
 * ��һ����������ӣ���һ��ֻ��װ��10����Ĵ��ӣ����³�100����ʱ����������10��
 * ���� 1 ~ 100 ���е�ÿһ����ѡ�еĸ��ʶ���10/100��
 * Ȼ��������򣬵��³�1000����ʱ���������� 10 ���򣬲���1~1000���е�ÿһ����ѡ�еĸ��ʶ���10/1000��
 * �������򣬵��³� i ����ʱ���������� 10 ���򣬲��� 1 ~ i ���е�ÿһ����ѡ�еĸ��ʶ��� 10/i��
 * Ҳ��������N�ı仯�� 1 ~ N ����ѡ�еĸ��ʶ�̬�仯�� K/N��
 * �뽫�³���N����ʱ�����е���ı�ŷ��ء�
 * ˼·:��NС��Kʱ��N�ض�ѡ�������������K/N�ĸ���ѡ������
 * 
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoSeven {


	private  Random rand = new Random();
	private int[] result;
	private int k;
	public DemoSeven(int k) {
		result = new int[k];
		this.k = k;
	}
	/**
	 * ÿ���������
	 * @param n ȡ��n����
	 * @return int[] �������˵ڼ�����
	 */
	public int[] machineSpit(int n) {
		if(n <= k) {
			result[n-1] = n;
		}else {
			int index = rand.nextInt(n);//�������k���� 
			if(index < k) {
				result[index] = n;
			}
		}
		return result;
	}
}
