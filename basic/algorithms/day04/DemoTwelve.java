package algo.day04;

/**
 * 现在有两个无环单链表，若两个链表的长度分别为m和n,请设计一个时间复杂度为O(M+N), 额外空间复杂度为O(1)的算法，
 * 判断这两个链表是否相交。给定两个链表的头节点headA和headB， 请返回一个bool值，代表这两个链表是否相交，保证两个链表的长度小于等于500
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoTwelve {

	/**
	 * 可以利用数组存放，遍历另一个看看有没有相同节点，没有的话那就没有
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static boolean checkIntersect(Node headA, Node headB) {
		if (headA == null || headB == null) {
			return false;
		}
		// 1.如果相交，那么相交后的节点就是一样的了,加入M > N，所以需要在 先遍历M -N +1个节点,然后再比较
		int numA = 0;
		Node currentNode = headA;
		while (currentNode != null) {
			numA++;
			currentNode = currentNode.next;
		}
		int numB = 0;
		currentNode = headB;
		while (currentNode != null) {
			numB++;
			currentNode = currentNode.next;
		}
		currentNode = headA;
		Node currentHeadBNode = headB;
		int offset = 0;
		boolean isNodeA = false;
		if (numA > numB) {
			offset = numA - numB + 1;
			isNodeA = true;
		} else {
			offset = numB - numA + 1;
		}

		int j = 1;
		while (j < offset) {
			j++;
			if (isNodeA) {
				currentNode = currentNode.next;
			} else {
				currentHeadBNode = currentHeadBNode.next;
			}
		}

		
		while(currentHeadBNode != null && currentNode != null) {
			if(currentHeadBNode == currentNode) {
				return true;
			}
			currentHeadBNode =  currentHeadBNode.next;
			currentNode = currentNode.next;
		}
		return false;
	}
	/**
	 * 有环单链表时 判断两条链表到入环节点处之前是否有相交节点
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static Node checkIntersectLoop(Node headA, Node headB,Node stopNode) {
		
		// 1.如果相交，那么相交后的节点就是一样的了,加入M > N，所以需要在 先遍历M -N +1个节点,然后再比较
		int numA = 0;
		Node currentNode = headA;
		while (currentNode != null) {
			numA++;
			currentNode = currentNode.next;
		}
		int numB = 0;
		currentNode = headB;
		while (currentNode != null) {
			numB++;
			currentNode = currentNode.next;
		}
		currentNode = headA;
		Node currentHeadBNode = headB;
		int offset = 0;
		boolean isNodeA = false;
		if (numA > numB) {
			offset = numA - numB + 1;
			isNodeA = true;
		} else {
			offset = numB - numA + 1;
		}

		int j = 1;
		while (j < offset) {
			j++;
			if (isNodeA) {
				currentNode = currentNode.next;
			} else {
				currentHeadBNode = currentHeadBNode.next;
			}
		}

		
		while(currentHeadBNode != stopNode && currentNode != stopNode) {
			if(currentHeadBNode == currentNode) {
				return currentHeadBNode;
			}
			currentHeadBNode =  currentHeadBNode.next;
			currentNode = currentNode.next;
		}
		return null;
	}
}
