package algo.day06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

/**
 * �ݹ�������ͷǵݹ��������ӡ
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoOne {

	/**
	 * �ݹ��ӡ
	 * 
	 * @param head
	 */
	public void recursivePreNode(Node head) {
		if (head == null) {
			return;
		}
		// �� �� ��
		System.out.print(head.value + " -> ");
		recursivePreNode(head.left);
		recursivePreNode(head.right);
	}

	public void recursiveInOrderNode(Node head) {
		if (head == null) {
			return;
		}
		// �� �� ��
		recursiveInOrderNode(head.left);
		System.out.print(head.value + " -> ");
		recursiveInOrderNode(head.right);
	}

	public void recursivePostOrderNode(Node head) {
		if (head == null) {
			return;
		}
		// �� �� ��
		recursivePostOrderNode(head.left);
		recursivePostOrderNode(head.right);
		System.out.print(head.value + " -> ");
	}

	/**
	 * �ǵݹ��ӡ
	 * 
	 * @param head
	 */
	public void unRecursivePreNode(Node head) {
		// �� ��
		// �� �� ��
		if (head == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		Node currentNode = null;
		while (!stack.isEmpty()) {
			currentNode = stack.pop();
			System.out.print(currentNode.value + " -> ");
			if (currentNode.right != null) {
				stack.push(currentNode.right);
			}
			if (currentNode.left != null) {
				stack.push(currentNode.left);
			}

		}
	}

	public void unRecursiveInOrderNode(Node head) {
		if (head == null) {
			return;
		}
		// ���� �� �� ��
		Stack<Node> stack = new Stack<>();
		Node currentNode = head;

		while (!stack.isEmpty() || currentNode != null) {
			while (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			// ��� ��ڵ�
			currentNode = stack.pop();
			System.out.print(currentNode.value + " -> ");
			currentNode = currentNode.right;
		}
	}

	/**
	 * ���������һ��д��
	 * 
	 * @param head
	 */
	public void unRecursivePostOrderNode(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		// �� �� ��
		s1.push(head);
		Node currentNode = null;
		while (!s1.isEmpty()) {
			currentNode = s1.pop();
			s2.push(currentNode);
			if (currentNode.left != null) {
				s1.push(currentNode.left);
			}
			if (currentNode.right != null) {
				s1.push(currentNode.right);
			}
		}
		while (!s2.empty()) {
			System.out.print(s2.pop().value + " -> ");
		}
	}

	public void unRecursivePostOrderTwo(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Node h = head;// ���һ�ε�������ӡ�Ľڵ�
		Node c = null;// ��ǰջ���ڵ�
		stack.push(head);
		while (!stack.isEmpty()) {
			c = stack.peek();// ȡջ����һ���ڵ�
			if (c.left != null && h != c.left && c.right != h) {
				stack.push(c.left);
			} else if (c.right != null && h != c.right) {
				stack.push(c.right);
			} else {
				// c.left ���� c.right ==null h==c.left c.right
				System.out.print(c.value + " -> ");
				h = c;
				stack.pop();
			}
		}
	}

	/**
	 * �����ӡ������
	 */
	public void layerNode(Node head) {
		if (head == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		Node currentNode = null;
		while (!queue.isEmpty()) {
			currentNode = queue.poll();
			System.out.print(currentNode.value + " -> ");
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
	}

	/**
	 * ���㻻�д�ӡ
	 */
	public void layerNodeLn(Node head) {
		if (head == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		Node last = head;//��ǰ���ڴ�ӡ�ĵ�ǰ�е����ҽڵ�
		Node nLast = head;//��һ�е����ҽڵ�
		Node currentNode = null;
		while (!queue.isEmpty()) {
			currentNode = queue.poll();
		
			if (currentNode.left != null) {
				queue.add(currentNode.left);
				nLast = currentNode.left;
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
				nLast = currentNode.right;
			}
			
			System.out.print(currentNode.value + " -> ");
			if (currentNode == last) {
				System.out.println();// ����
				last = nLast;
			}
		}
	}
	/**
	 * �ڵ����л� ����һ
	 */
	public String seriableNode(Node head) {
		if(head == null) {
			return "#!";
		}
		StringBuilder sb = new StringBuilder();
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		Node currentNode = null;
		while(!stack.isEmpty()) {
			currentNode = stack.pop();
			sb.append(currentNode.value+"!");
			if(currentNode.right!= null) {
				stack.push(currentNode.right);
			}else {
				sb.append("#!");
			}
			if(currentNode.left != null) {
				stack.push(currentNode.left);
			}else {
				sb.append("#!");
			}
		}
		return sb.toString();
	}
	public String seriableNode2(Node head,String result) {
		if(head == null) {
			result += "#!";
			return result;
		}
		result += (head.value+"!");
		seriableNode2(head.left, result);
		seriableNode2(head.right, result);
		return result;
	}
	int index = 0;
	public Node unSeriableNode(String data) {
		if("#!".equals(data)) {
			return null;
		}
		String[] result = data.split("!");
		if("#".equals(result[index])) {
			index ++;
			return null;
		}
		Node node = new Node(Integer.parseInt(result[index]), null, null);
		node.left = unSeriableNode(data);
		node.right = unSeriableNode(data);
		return node;
	}
	public Node unSeriableNode2(String data) {
		if("#!".equals(data)) {
			return null;
		}
		Queue<String> queue = new LinkedList<>();
		String[] result = data.split("!");
		for(int i = 0;i<result.length;i++) {
			queue.add(result[i]);
		}
		return unSeriablePreNode(queue);
		
	}
	private Node unSeriablePreNode(Queue<String> queue) {
		String deal = queue.poll();
		if("#".equals(deal)) {
			return null;
		}
		Node node = new Node(Integer.parseInt(deal), null, null);
		node.left = unSeriablePreNode(queue);
		node.right = unSeriablePreNode(queue);
		return node;
	}
}
