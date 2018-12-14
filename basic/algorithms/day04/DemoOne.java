package algo.day04;

/**
 * 有一个整数val,如何在节点有序的环形链表中插入一个节点值为val的节点，
 * 并且保证这个环形单链表依然有序。给定链表的信息，及元素的值A及对应的next指向的元素编号， 同时给定val,请构造出这个环形链表，并插入该值。如
 * [1,3,4,5,7],[1,2,3,4,0],2 返回 [1,2,3,4,5,7]
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoOne {
	/**
	 * 注意事项:循环单链表 需要最后节点指向next//本人nextNode newNode 由于IDE提示过快导致错了，纠结半天
	 * @param A
	 * @param next
	 * @param value
	 * @return
	 */

	public int[] insert(int[] A, int[] next, int value) {
		if (A == null || next == null) {
			return new int[] { value };
		}
		Node head = createCircleNode(A, next);
		Node co = head;
		while (true) {
			System.out.println(co.value);
			co = co.next;
			if(co == head) {
				break;
			}
		}
		Node newNode = new Node(value);

		Node previousNode = head;
		Node nextNode = head.next;

		while (nextNode != head) {
			if (previousNode.value <= value && nextNode.value > value) {
				previousNode.next = newNode;
				newNode.next = nextNode;
				break;
			}

			previousNode = previousNode.next;
			nextNode = nextNode.next;
		}
		if (nextNode == head) {
			if (previousNode.value <= value) {
				previousNode.next = newNode;
				newNode.next = head;
			} else {
				previousNode.next = newNode;
				newNode.next = head;
				head = newNode;
			}
		}

		// 插入完毕
		int[] data = new int[A.length + 1];
		Node currentNode = head;
		int i = 0;
		while (i < data.length) {
			data[i] = currentNode.value;
			currentNode = currentNode.next;
			i++;
		}
		return data;

	}

	/**
	 * 首先节点是有序的 构造环形链表
	 * 
	 * @param A
	 * @param next
	 * @param value
	 * @return
	 */
	private Node createCircleNode(int[] A, int[] next) {
		if (A.length == 1) {
			Node node = new Node(A[0]);
			node.next = node;
			return node;
		}
		Node head = new Node(A[0]);
		Node currentNode = head;
		int index = next[0];//存放的是对应指向元素下标，默认第一个元素指向的下标
		for (int i = 0; i < A.length - 1; i++) {
			Node newNode = new Node(A[index]);
			currentNode.next = newNode;
			currentNode = currentNode.next;
			index = next[index];//这里index是指元素的下标，那么它的值就是A内下标，同样页时next内的

		}
		currentNode.next = head;
		return head;
	}
}
