package algo.day04;

/**
 * ��һ������val,����ڽڵ�����Ļ��������в���һ���ڵ�ֵΪval�Ľڵ㣬
 * ���ұ�֤������ε�������Ȼ���򡣸����������Ϣ����Ԫ�ص�ֵA����Ӧ��nextָ���Ԫ�ر�ţ� ͬʱ����val,�빹���������������������ֵ����
 * [1,3,4,5,7],[1,2,3,4,0],2 ���� [1,2,3,4,5,7]
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoOne {
	/**
	 * ע������:ѭ�������� ��Ҫ���ڵ�ָ��next//����nextNode newNode ����IDE��ʾ���쵼�´��ˣ��������
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

		// �������
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
	 * ���Ƚڵ�������� ���컷������
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
		int index = next[0];//��ŵ��Ƕ�Ӧָ��Ԫ���±꣬Ĭ�ϵ�һ��Ԫ��ָ����±�
		for (int i = 0; i < A.length - 1; i++) {
			Node newNode = new Node(A[index]);
			currentNode.next = newNode;
			currentNode = currentNode.next;
			index = next[index];//����index��ָԪ�ص��±꣬��ô����ֵ����A���±꣬ͬ��ҳʱnext�ڵ�

		}
		currentNode.next = head;
		return head;
	}
}
