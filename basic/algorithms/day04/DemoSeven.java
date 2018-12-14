package algo.day04;

import java.util.Stack;

/**
 * ���дһ����������������Ƿ�Ϊ���ġ� ����һ������head,�뷵��һ��bool,���������Ƿ�Ϊ���ġ� �������� [1,2,3,2,1] ����true
 * [1,2,3,2,3] ����false
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoSeven {

	/**
	 * �Ƿ��ǻ��� 
	 * ����һ ����ָ��
	 * �ַ����Ļ�����ֱ����StringBuffer��ת �Ƚϻ���toCharArray�Ƚ�
	 * @param data
	 * @return
	 */
	public boolean isPalindrome(int[] data) {

		if (data == null) {
			return false;
		}
		Node head = createHead(data);

		Node slow = head;
		Node fast = head;
		Node previous = null;
		while(fast != null && fast.next != null) {//������֤slow�����м�λ��ʱ����ƶ���һλ
			fast = fast.next.next;
			
			Node next = slow.next;
			slow.next = previous;
			previous = slow;
			slow = next;
			
		}
		if(fast!=null) {
			slow = slow.next;
		}
		while(previous != null && slow != null) {
			
			if(previous.value != slow.value) {
				return false;
			}
			previous = previous.next;
			slow = slow.next;
		}
		return true;
	}

	/**
	 * ������ ջ
	 * �ռ临�Ӷ� O(N)
	 * @param data
	 * @return
	 */
	public boolean isPalindrome2(int[] data) {

		if (data == null) {
			return false;
		}
		Node head = createHead(data);
		Node currentNode = head;
		Stack<Node> stack = new Stack<>();
		while (currentNode != null) {
			stack.push(currentNode);
			currentNode = currentNode.next;
		}
	
			Node newHead = stack.pop();
			Node tempNode = newHead;
			while(!stack.isEmpty()) {
				tempNode.next = stack.pop();
				tempNode = tempNode.next;
			}
			tempNode.next = null;
		while(head != null && newHead != null) {
			if(head.value != newHead.value) {
				return false;
			}
			head = head.next;
			newHead = newHead.next;
		}

		return true;
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
