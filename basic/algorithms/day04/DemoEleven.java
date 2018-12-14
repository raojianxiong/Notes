package algo.day04;

/**
 * ����ж�һ���������Ƿ��л����л��Ļ����ؼ�¼���ĵ�һ���ڵ��ֵ��
 * �޻��Ļ�����-1���������ĳ���ΪN��������ʱ�临�Ӷ�ΪO(N),����ռ临�Ӷ�ΪO(1)��
 * ����һ���������ͷ�ڵ�head(ע����һ������adjustΪ���ܺ�����ݵ��������� ������������,�뱾������޹�)�뷵������ֵ
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoEleven {

	/**
	 * ����ʹ�����飨hashӳ�䣩�������ڵ㣬���������û���ظ��ڵ㣬��ô�޻�
	 * �뻷ǰ��Ҫ�� m ��,������ n ���ڵ㣬ע�⻷���� n ���ڵ�
	 * fast �� slow ����ʱ slow �ܹ��߹� S ,fast�� 2 S
	 * �� (S -m)%n = (2S -m)%n ����ָ��λ��һ����S%n == 2S % n
	 * �ó�  S % n = 0 
	 * ���԰� fast �Żر�ͷ,Ȼ���� m �� ����ζ��slow ���� m �� 
	 * slow ��λ���� (S - m)% n + m % n -->> S % n == 0 ,�뻷��λ��
	 * @param head
	 * @param adjust
	 * @return
	 */
	public static int checkLoop(Node head, int adjust) {
		if (head == null || head.next == null) {
			return -1;
		}
		// 1.����ָ��
		Node slow = head;
		Node fast = head;

		boolean isMeet = false;
		while (fast!=null&& fast.next!= null) {
			slow = slow.next;
			fast = fast.next.next;
			// 2.��������޻�����ôfastһ���ȵ��յ�
			if (fast == null) {
				return -1;
			}
			// 3.���slow ��fast�����ˣ���fast�ص�head�ڵ㣬����֤��������ע��
			if (slow == fast) {
				if (!isMeet) { 
					fast = head;
					isMeet = true;
				}else {
					//�����������������һ��,����ڵ����뻷�ڵ�
					return slow.value;
				}
			}
		}
		return -1;
	}
	public static Node checkLoopNode(Node head, int adjust) {
		if (head == null || head.next == null) {
			return null;
		}
		// 1.����ָ��
		Node slow = head;
		Node fast = head;

		boolean isMeet = false;
		while (slow != null) {
			slow = slow.next;
			if (!isMeet) {
				fast = fast.next;
			} else {
				fast = fast.next;
			}
			// 2.��������޻�����ôfastһ���ȵ��յ�
			if (fast == null) {
				return null;
			}
			// 3.���slow ��fast�����ˣ���fast�ص�head�ڵ㣬����֤��������ע��
			if (slow == fast) {
				if (!isMeet) {
					fast = head;
					isMeet = true;
				}else {
					//�����������������һ��,����ڵ����뻷�ڵ�
					return slow;
				}
			}
		}
		return null;
	}
}
