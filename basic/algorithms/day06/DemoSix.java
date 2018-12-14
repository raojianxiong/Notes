package algo.day06;

/**
 * �Ӷ������Ľڵ�A�������������ϻ��������ߣ�����;�Ľڵ�ֻ�ܾ���һ�Σ�
 * ������ڵ�Bʱ��·���ϵĽڵ�������A��B�ľ��룬���ڸ�����һ�ö�������
 * ���������Ͻڵ��������� 
 * @author Jianxiong Rao
 *
 */
public class DemoSix {

	public static int lognestDistance(Node head) {
		if(head == null) {
			return 0;
		}
		int distance = postOrderFindLongest(head);
		return distance;
	}
	/**
	 * int[] leftDistance/rightDistance 
	 * 0 �ڵ� �������������� 1�������Ͼ���ڵ����ӵ���Զ����
	 * @param root
	 * @return
	 */
	private static int postOrderFindLongest(Node root) {
		if(root == null) {
			return 0;
		}

		int leftDistance ,rightDistance;
		leftDistance = postOrderFindLongest(root.left);
		rightDistance = postOrderFindLongest(root.right);
		
		int r1 = ((leftDistance > rightDistance) ?leftDistance :rightDistance) + 1;
		//node�ڵ������ ����������Զ����  + 1 = ��node�ڵ�ľ��룬�ҽڵ����ƣ�����+2?
		int r2 = ((leftDistance + rightDistance +2)> r1 )?(leftDistance + rightDistance + 2):r1;
		return r2;
	}
}
