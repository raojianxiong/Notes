package algo.day04;

/**
 * 对于一个链表，我们需要一个特定阀值完成对它的分化，
 * 使得小于等于这个值的节点移动到前面，大于该值的节点移到后面，同时保证两类节点的内部位置关系不变。给定一个链表的头节点head,同时给定阀值val,请返回一个链表，使小于等于它的节点在前，
 * 大于等于它的节点在后，保证节点值不重复。[1,4,2,5],3 返回 [1,2,4,5]
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoThree {

	public int[] convertNodes(int[] data, int value) {
		if (data == null) {
			return null;
		}
		Node head = new Node(data[0]);
		Node currentNode = head;
		for (int i = 1; i < data.length; i++) {
			Node newNode = new Node(data[i]);
			currentNode.next = newNode;
			currentNode = currentNode.next;
		}
		// 3条链表
		currentNode = head;
		Node node1 = null;
		Node newHead = null;
		Node node2 = null;
		Node newHead2 = null;
		Node node3 = null;
		Node newHead3 = null;
		while (currentNode != null) {
			if (currentNode.value <value) {
				if (node1 == null) {
					node1 = currentNode;
					newHead = currentNode;
				} else {
					node1.next = currentNode;
					node1 = node1.next;
				}
			} else if (currentNode.value == value) {
				if (node2 == null) {
					node2 = currentNode;
					newHead2 = currentNode;
				} else {
					node2.next = currentNode;
					node2 = node2.next;
				}
			} else {
				if (node3 == null) {
					node3 = currentNode;
					newHead3 = currentNode;
				} else {
					node3.next = currentNode;
					node3 = node3.next;
				}
			}
			currentNode = currentNode.next;
		}
		//需要判断，，万一没有相等的呢等边界条件
		if (node2 == null) {
			node1.next = newHead3;
		} else {
			node1.next = newHead2;
			node2.next = newHead3;
		}
		head = newHead;
		int i = 0;
		while (head != null) {
		
			data[i] = head.value;
			i++;
			head = head.next;
		}
		return data;
	}
}
