package algo.day09;

/**
 * nֻ���ϴ���n���͵�n���������ű��ƶ����ٶ�����ͬ�ģ���������ͷ�ĸ����Ƕ��٣�
 * ����һ��������n,�뷵��һ�����飬��������Ԫ�طֱ�Ϊ����ķ��Ӻͷ�ĸ���뻯Ϊ��������
 * @author Jianxiong Rao
 *
 */
public class DemoTwo {

	public static int[] ants(int n) {
		int[] result = new int[] {1,1};
		 result[1] = (int) Math.pow(2, n);
		result[0] = result[1] - 2;
		int gcd = maxGcd(result[0], result[1]);
		result[0] /= gcd;
		result[1] /= gcd;
		return result;
	}
	
	private static int maxGcd(int x,int y) {
	
//		int max = x> y?x:y;
//		int min = x>y?y:x;
//		if(max - min == min) {
//			return min;
//		}
//		return maxGcd(max, min);
		if(x % y == 0)return y;
		return maxGcd(y, x%y);
	}
}
