package algo.day11;
/**
 * A��B����Ϸ����һ�� n * m �ľ����еĳ������� (1,m),�յ��� (n,1),
 * ������ֻ�������ƶ�һ�������ƶ�һ��������һ�ƶ�һ��,���ߵ��յ��Ϊwinner��A���ߡ�
 * ������������n��m,�뷵�����Ļ�ʤ�ߵ�����(A��B)������������5 3 ���� ��B
 * @author Jianxiong Rao
 *
 */
public class DemoFour {

	public static String getWinner(int n,int m) {
		//��2����Ϊ0���ǿ϶���AӮ
		if(m%2!=0 && n%2 !=0) {
			return "B";
		}else {
			return "A";
		}
	}
}
