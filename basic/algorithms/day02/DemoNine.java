package algo.day02;

/**
 * 对于字符串A和B，如果A和B中出现字符串种类相同且每种字符出现的次数相同， 则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 * 给定两个字符串A和B以及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoNine {
	public boolean checkIsDeformation(String A, String B, int aLength, int bLength) {
		//建立两个char类型数组，大小为256？
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
