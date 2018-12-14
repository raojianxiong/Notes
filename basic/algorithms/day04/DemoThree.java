package algo.day04;

/**
 * ����һ������������Ҫһ���ض���ֵ��ɶ����ķֻ���
 * ʹ��С�ڵ������ֵ�Ľڵ��ƶ���ǰ�棬���ڸ�ֵ�Ľڵ��Ƶ����棬ͬʱ��֤����ڵ���ڲ�λ�ù�ϵ���䡣����һ�������ͷ�ڵ�head,ͬʱ������ֵval,�뷵��һ������ʹС�ڵ������Ľڵ���ǰ��
 * ���ڵ������Ľڵ��ں󣬱�֤�ڵ�ֵ���ظ���[1,4,2,5],3 ���� [1,2,4,5]
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
		// 3������
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
		//��Ҫ�жϣ�����һû����ȵ��صȱ߽�����
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
