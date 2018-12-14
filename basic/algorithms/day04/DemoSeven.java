package algo.day04;

import java.util.Stack;

/**
 * 请编写一个函数，检查链表是否为回文。 给定一个链表head,请返回一个bool,代表链表是否为回文。 测试样例 [1,2,3,2,1] 返回true
 * [1,2,3,2,3] 返回false
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoSeven {

	/**
	 * 是否是回文 
	 * 方法一 快慢指针
	 * 字符串的话可以直接用StringBuffer反转 比较或者toCharArray比较
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
		while(fast != null && fast.next != null) {//这样保证slow处于中间位置时向后移动了一位
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
	 * 方法二 栈
	 * 空间复杂度 O(N)
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
