package algo.day02;

/**
 * �����ַ���A��B�����A��B�г����ַ���������ͬ��ÿ���ַ����ֵĴ�����ͬ�� ��A��B��Ϊ���δʣ������һ����Ч�㷨��������������Ƿ�Ϊ���δʡ�
 * ���������ַ���A��B�Լ����ǵĳ��ȣ��뷵��һ��boolֵ�����������Ƿ�Ϊ���δʡ�
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoNine {
	public boolean checkIsDeformation(String A, String B, int aLength, int bLength) {
		//��������char�������飬��СΪ256��
		if(A == null || B ==  null || aLength != bLength) {
			return false;
		}
		char[] charA = A.toCharArray();
		char[] charB = B.toCharArray();
		int[] map = new int[256];
		for(int i = 0;i<charA.length;i++) {
			map[charA[i]] ++;
		}
		for(int i = 0;i<charA.length;i++) {
			if(map[charB[i]] -- == 0) {
				return false;
			}
		}
		return true;
	}
}
