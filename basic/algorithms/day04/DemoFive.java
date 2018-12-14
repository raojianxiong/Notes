package algo.day04;

import java.util.Stack;

/**
 * ��һ�������������һ���㷨��ʹ��ÿK���ڵ�֮������ �����󲻹�K���ڵ�һ�飬�򲻵�����󼸸��ڵ㣬
 * ����1->2->3->4->5->6->7->8->null ,K = 3������ӣ� ������Ϊ
 * 3->2->1->6->5->4->7->8->null,��ΪK == 3,����ÿ�����ڵ�֮�����򣬵����е�7��8��������
 * ��Ϊֻ�������ڵ㲻��һ�顣����һ���������ͷָ�룬ͬʱ����Kֵ����������������ͷָ�롣
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoFive {
	public int[] reverseNode(int[] data, int K) {
		if (data == null || data.length < 2) {
			return data;
		}
		// ����һ���������ͷָ��
		Node head = createHead(data);
		// K ÿK��֮�䷴ת ����ʹ��ջ �ռ临�Ӷ�O(N)
		int i = 1;
		Node previous = null;
		Node currentNode = head;
		Node beforeHead = head;

		Node lastTail = null;
		int count = 0;
		while (currentNode != null) {

			if (i == K) {
				// ��ת
				if (count == 0) {
					head = currentNode;
				} else {
					lastTail.next = currentNode;// ֮ǰ��������Ķ����͵�ǰ�����β��
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
				currentNode = temp;// ������Ҫ��ֵ����Ϊ���һ���ڵ㣬����K���ڵ�ָ�����ǰһ���ڵ���
				i = 1;
				count++;
			}

			// ����currentNode���ܻ�Ϊ�յģ���ִ����while���� temp Ϊ��
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
	 * ���������ƣ���������Ż�����Ҫ������ջ������
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
				Node copy = currentNode.next;// ��Ҫע��currentNode�ڵ�
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
				//�����Ҫע��
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
