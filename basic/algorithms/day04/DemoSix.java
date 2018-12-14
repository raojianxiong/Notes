package algo.day04;

/**
 * ������һ��������������ÿ���ڵ㱣��һ���������ٸ���һ��ֵval,�����е���val�Ľڵ�ɾ���� ����һ���������ͷ�ڵ�head,
 * ͬʱ����һ��ֵval,�뷵�������������ͷ�ڵ㣬 ��֤�������в����ڸ�ֵ������ֵ���뱣֤����Ԫ�ص����˳�� [1,2,3,4,3,2,1] 2 ����
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
