package algo.day04;

/**
 * 如何判断一个单链表是否有环？有环的话返回记录环的第一个节点的值，
 * 无环的话返回-1，如果链表的长度为N，请做到时间复杂度为O(N),额外空间复杂度为O(1)。
 * 给定一个单链表的头节点head(注意另一个参数adjust为加密后的数据调整参数， 方便数据设置,与本题求解无关)请返回所求值
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoEleven {

	/**
	 * 可以使用数组（hash映射），遍历节点，如果数组内没有重复节点，那么无环
	 * 入环前需要走 m 步,环中有 n 个节点，注意环中有 n 个节点
	 * fast 和 slow 相遇时 slow 总共走过 S ,fast则 2 S
	 * 则 (S -m)%n = (2S -m)%n 快慢指针位置一样，S%n == 2S % n
	 * 得出  S % n = 0 
	 * 所以把 fast 放回表头,然后走 m 步 ，意味着slow 走了 m 步 
	 * slow 的位置是 (S - m)% n + m % n -->> S % n == 0 ,入环的位置
	 * @param head
	 * @param adjust
	 * @return
	 */
	public static int checkLoop(Node head, int adjust) {
		if (head == null || head.next == null) {
			return -1;
		}
		// 1.快慢指针
		Node slow = head;
		Node fast = head;

		boolean isMeet = false;
		while (fast!=null&& fast.next!= null) {
			slow = slow.next;
			fast = fast.next.next;
			// 2.如果链表无环，那么fast一定先到终点
			if (fast == null) {
				return -1;
			}
			// 3.如果slow 和fast相遇了，让fast回到head节点，做法证明见方法注释
			if (slow == fast) {
				if (!isMeet) { 
					fast = head;
					isMeet = true;
				}else {
					//相遇的情况又遇到了一次,这个节点是入环节点
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
		// 1.快慢指针
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
			// 2.如果链表无环，那么fast一定先到终点
			if (fast == null) {
				return null;
			}
			// 3.如果slow 和fast相遇了，让fast回到head节点，做法证明见方法注释
			if (slow == fast) {
				if (!isMeet) {
					fast = head;
					isMeet = true;
				}else {
					//相遇的情况又遇到了一次,这个节点是入环节点
					return slow;
				}
			}
		}
		return null;
	}
}
