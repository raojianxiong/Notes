package algo.day04;

/**
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该节点， 给定带删除的节点，请执行删除操作， 若该节点为尾节点， 返回false,否则返回true
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
