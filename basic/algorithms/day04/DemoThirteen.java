package algo.day04;

/**
 * 如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点， 不相交的话返回空，如果两个链表长度分别为N和M，请做到时间复杂度为O(N+M),
 * 额外空间复杂度O(1)。给定两个链表的头节点head1和head2(注意，另外两个参数adjust0和djust1用于调整数据，与本题求解无关)。
 * 请返回一个bool值代表他们是否相交。
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoThirteen {

	/**
	 * 现在是两个有环单链表
	 * 
	 * @param head1
	 * @param head2
	 */
	public static Node checkIntersect(Node head1, Node head2, int adjust0, int adjust1) {
		// 1. 先找到各自入环的节点
		Node loop1 = DemoEleven.checkLoopNode(head1, adjust0);
		Node loop2 = DemoEleven.checkLoopNode(head2, adjust1);
		if (loop1 == null || loop2 == null) {
			return null;
		}
		// 2. 两个入环节点一样 ,说明有环 ,可能在这之前就已经相交了，需要找到第一个相交的节点,那就是从首节点开始找，终止条件为入环节点
		if (loop1 == loop2) {
			Node node = DemoTwelve.checkIntersectLoop(head1, head2, loop1);
			if (node == null) {
				return loop1;
			} else {
				return node;
			}
		}else {
			//3.如果入环点不一样 ,可能是从不同的点入环
			Node p = loop1.next;
			while(p!=null) {
				if(p == loop2) {
					return p;
				}
				p = p.next;
			}
		}
		return null;
	}
}
