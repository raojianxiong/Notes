package algo.day04;

/**
 * 现在有一个单链表，链表中每个节点保存一个整数，再给定一个值val,把所有等于val的节点删掉。 给定一个单链表的头节点head,
 * 同时给定一个值val,请返回清除后的链表的头节点， 保证链表中有不等于该值的其它值。请保证其它元素的相对顺序 [1,2,3,4,3,2,1] 2 返回
 * [1,3,4,3,1]
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoSix {

	public int[] deleteNode(int[] data, int value) {
		if (data == null) {
			return data;
		}
		Node head = createHead(data);
		Node currentNode = head;
		Node previous = new Node(-1);
		previous.next = head;
		int count = 0;
		while (currentNode != null) {
//			
//			if(currentNode.value != value) {
//				if(currentNode.next != null && currentNode.next.value == value) {
//					currentNode.next = currentNode.next.next;
//					count ++;
//				}
//			}
			if (currentNode.value == value) {
				previous.next = currentNode.next;
				count++;
			} else {
				previous = previous.next;
			}
			currentNode = currentNode.next;

		}
		int[] result = new int[data.length - count];
		int i = 0;
		while (head != null) {
			result[i] = head.value;
			i++;
			head = head.next;
		}

		return result;
	}

	private Node createHead(int[] data) {
		Node head = new Node(data[0]);
		Node currentNode = head;
		for (int i = 1; i < data.length; i++) {
			Node newNode = new Node(data[i]);
			currentNode.next = newNode;
			currentNode = currentNode.next;
		}
		return head;
	}
}
