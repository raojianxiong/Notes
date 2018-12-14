package algo.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * ���һ��ֽ�����ŷ��������ϣ�Ȼ���ֽ�����±����Ϸ�����1�Σ�
 * ѹ���ۺۺ�չ������ʱ�ۺ��ǰ���ȥ�ģ����ۺ�ͻ��ķ���ָ��ֽ���ı��档
 * �����ֽ�����±����Ϸ������������Σ�ѹ���ۺۺ�չ������ʱ�������ۺۣ�
 * ���ϵ���һ�������ۺۡ����ۺۺ����ۺۡ�
 * ����һ���������N������ֽ�������±����Ϸ���������N�Σ�
 * ����ϵ��´�ӡ�����ۺ۵ķ���
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoFour {

	/**
	 * ��һ�� ��
	 * �ڶ��� �� �£���һ�Σ� ��
	 * �����ֶ��۵���Ȼ�󻭸�ͼ ���ָ�����������������ı������� �� �� �������
	 * @param N
	 */
	public static List<String> folderPager(int N) {
	
		if(N <= 0) {
			return null;
		}
		List<String> data = new ArrayList<>();
		if(N == 1) {
			data.add("down");
			return data;
		}
		reInOrder(N-1, true, data);
		data.add("down");
		reInOrder(N-1,false, data);
		return data;
		
	}
	private static void reInOrder(int n,boolean flag,List<String> data) {
		if(n == 0) {
			return;
		}
		reInOrder(n-1, true, data);
		if(flag) {
			data.add("down");
		}else {
			data.add("up");
		}
		reInOrder(n-1,false, data);
	}
}
