package algo.day05;


import algo.day04.Node;

/**
 * ����һ����ȫ�������ĸ��ڵ�root,����������Ľڵ�����������ȫ�������Ľڵ���ΪN��
 * ��ʵ��ʱ�临�Ӷȵ���O��N���Ľⷨ���������ĸ��ڵ�root,�뷵�����Ĵ�С
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoFive {

	/**
	 * �߶�Ϊh�������������ڵ�Ϊ 2 ��h�η� - 1
	 * @param head
	 * @return
	 */
	public static int countTree(Node head) {
		if (head == null) {
			return 0;
		}
		int lengthOfLeft = depthTree(head.previous);
		int lengthOfRight = depthTree(head.next);
		if(lengthOfLeft == lengthOfRight) {//������һ�����������������������ϸ��ڵ� 2 ^ n - 1 + 1
			return (int) (Math.pow(2,lengthOfLeft) + countTree(head.next));
		}else {
			return (int) (Math.pow(2, lengthOfRight) + countTree(head.previous));
		}

	}
	/**
	 * node�ڵ�Ĳ���
	 * @param node
	 * @return
	 */
	private static int depthTree(Node node) {
		if(node == null) {
			return 0;
		}
		int len = 0;
		Node p = node;
		while(p != null) {
			len ++;
			p = p.previous;
		}
		return len;
	}
}
