package algo.day09;

/**
 * ��2kֻ����ӣ���k-1��ǿ�ӣ����඼�����ӣ�
 * ��������Ƿֳ�k�飬ÿ�������ӣ�����ǿ�����ĸ����Ƕ�󣿸���һ����k��
 * �뷵��һ�����飬����������Ԫ�أ��ֱ�Ϊ���յķ��Ӻͷ�ĸ���뻯��������
 * @author Jianxiong Rao
 *
 */
public class DemoOne {

	public static int[] championship(int k) {
		int[] result = new int[] {1,1};
		for(int i = 2*k-1;i>0;i-=2) {
			result[1] *= i;
		}
		//���ʣ������
		for(int i = k+1;i>2;i--) {
			result[0] *=i;
		}
		result[0] = result[1] - result[0];
		int maxGcd = maxGcd(result[0], result[1]);
		result[0] /=maxGcd;
		result[1] /= maxGcd;
		return result;
		
	}
	/**
	 * ���������Ĺ�����
	 * @param x
	 * @param y
	 * @return
	 */
	private static int maxGcd(int x,int y) {
		if(x%y == 0) {return y;}
		else {
			return maxGcd(y, x%y);
		}
	}
}
