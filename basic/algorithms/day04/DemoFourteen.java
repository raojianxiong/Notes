package algo.day04;

/**
 * 给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？
 * 相交的话返回true,不相交的话返回false,
 * 给定两个链表的头节点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据，与本题求解无关)，
 * 请返回一个bool值代表他们是否相交。
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoFourteen {

	public static boolean isIntersect(Node head1,Node head2,int adjust0,int adjust1) {
		if(head1 == null || head2 == null) {
			return false;
		}
		// 1. 判断是否有环，一个有环 一个无环
		Node isHead1Circle = DemoEleven.checkLoopNode(head1, adjust0);
		Node isHead2Circle = DemoEleven.checkLoopNode(head2, adjust1);
		//2.一个有换，另一个无环 肯定不相交
		if(isHead1Circle == null && isHead2Circle != null) {
			return false;
		}
		if(isHead1Circle != null && isHead2Circle == null) {
			return false;
		}
		
		//3.两个都没环
		if(isHead1Circle == null && isHead2Circle == null) {
			return DemoTwelve.checkIntersect(head1, head2);
		}
		//4.两个都有环
		if(isHead1Circle != null && isHead2Circle != null) {
			Node node = DemoThirteen.checkIntersect(head1, head2, adjust0, adjust1);
			if(node != null) {
				return true;
			}
		}
		return false;
	}
}
