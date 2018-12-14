package algo.day04;

/**
 * ʵ��һ���㷨��ɾ�����������м��ĳ����㣬�ٶ���ֻ�ܷ��ʸýڵ㣬 ������ɾ���Ľڵ㣬��ִ��ɾ�������� ���ýڵ�Ϊβ�ڵ㣬 ����false,���򷵻�true
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoTwo {
	public boolean judgeIsTail(Node node) {
		if (node == null) {
			return false;
		}
		if (node.next == null) {
			return false;
		} else {
			Node next = node.next;
			node.value = next.value;
			node.next = next.next;
			next = null;
			return true;
		}
	}
}
