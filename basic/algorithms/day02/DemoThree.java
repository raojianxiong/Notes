package algo.day02;

/**
 * ��������������ϲ�Ϊһ�����飬��һ������ռ����ÿ����������������Ԫ��
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoThree {
	public static void sort() {
		int[] a = new int[7];
		a[0] = 2;
		a[1] = 4;
		a[2] = 6;
		a[3] = 9;
		int[] b = new int[3];
		b[0] = 1;
		b[1] = 3;
		b[2] = 6;
		int end = a.length - 1;
		int start = 0;
		int ak = 3;
		int bk = b.length - 1;
		while (start <= end) {
			if (ak < 0) {
				a[end] = b[bk];
				end --;
				bk --;
			} else if (bk < 0) {
				a[end] = a[ak];
				end--;
				ak --;
			} else if (b[bk] > a[ak]) {
				a[end] = b[bk];
				end--;
				bk--;
			} else {
				a[end] = a[ak];
				ak--;
				end--;
			}
		}
		for(int i:a) {
			System.out.print(i+"\t");
		}
	}
}
