package algo.day04;

import java.util.Stack;

/**
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序， 如果最后不够K个节点一组，则不调整最后几个节点，
 * 例如1->2->3->4->5->6->7->8->null ,K = 3这个例子， 调整后为
 * 3->2->1->6->5->4->7->8->null,因为K == 3,所以每三个节点之间逆序，但其中得7，8不调整，
 * 因为只有两个节点不够一组。给定一个单链表的头指针，同时给定K值，返回逆序后的链表头指针。
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoFive {
	public int[] reverseNode(int[] data, int K) {
		if (data == null || data.length < 2) {
			return data;
		}
		// 给定一个单链表的头指针
		Node head = createHead(data);
		// K 每K个之间反转 可以使用栈 空间复杂度O(N)
		int i = 1;
		Node previous = null;
		Node currentNode = head;
		Node beforeHead = head;

		Node lastTail = null;
		int count = 0;
		while (currentNode != null) {

			if (i == K) {
				// 逆转
				if (count == 0) {
					head = currentNode;
				} else {
					lastTail.next = currentNode;// 之前窗口链表的顶部和当前链表的尾部
				}
				int j = 0;

				previous = null;
				Node temp = currentNode.next;
				while (j < K) {
					if (j == 0) {
						lastTail = beforeHead;
					}
					Node node = beforeHead.next;
					beforeHead.next = previous;
					previous = beforeHead;
					beforeHead = node;
					j++;
					System.out.println("j == " + j);
					System.out.println(beforeHead == null);

				}
				// beforeHead = temp;
				currentNode = temp;// 这里需要赋值，因为最后一个节点，即第K个节点指向的是前一个节点了
				i = 1;
				count++;
			}

			// 这里currentNode可能会为空的，在执行完while语句后 temp 为空
			if (currentNode != null) {
				currentNode = currentNode.next;
			}
			i++;

		}
		currentNode = head;
		int m = 0;
		while (currentNode != null) {
			data[m] = currentNode.value;
			currentNode = currentNode.next;
			m++;
		}
		return data;
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

	/**
	 * 和上述类似，代码可以优化，主要是利用栈的性质
	 * @param data
	 * @param K
	 * @return
	 */
	public int[] reverseByStack(int[] data, int K) {
		if (data == null || data.length < 2) {
			return data;
		}
		Stack<Node> temp = new Stack<>();
		int i = 1;
		Node head = createHead(data);
		Node currentNode = head;
		int count = 0;
		Node tail = null;
		Node firstNode = null;
		while (currentNode != null) {

			if (i == 1) {
				firstNode = currentNode;
			}
			temp.push(currentNode);

			if (temp.size() == K) {
				Node copy = currentNode.next;// 需要注意currentNode节点
				if (count == 0) {
					head = temp.peek();
				} else {
					tail.next = temp.peek();
				}
				while (temp.size() > 0) {

					Node node = temp.pop();
					if (temp.size() != 0) {
						node.next = temp.peek();

					} else {
						node.next = null;
						tail = node;
						
						System.out.println("===");
					}

				}
				//这块需要注意
				i = 1;
				currentNode = copy;
				firstNode = currentNode;
				temp.push(currentNode);
				count++;
			} else {
				if (tail != null) {
					tail.next = firstNode;
				}
			}

			if (currentNode != null) {
				currentNode = currentNode.next;
			}
			i++;
		}
		currentNode = head;
		int m = 0;
		while (currentNode != null) {
			data[m] = currentNode.value;
			currentNode = currentNode.next;
			m++;
		}
		return data;
	}
}
