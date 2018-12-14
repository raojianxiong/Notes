package algo.day06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

/**
 * 递归二叉树和非递归二叉树打印
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoOne {

	/**
	 * 递归打印
	 * 
	 * @param head
	 */
	public void recursivePreNode(Node head) {
		if (head == null) {
			return;
		}
		// 根 左 右
		System.out.print(head.value + " -> ");
		recursivePreNode(head.left);
		recursivePreNode(head.right);
	}

	public void recursiveInOrderNode(Node head) {
		if (head == null) {
			return;
		}
		// 左 根 右
		recursiveInOrderNode(head.left);
		System.out.print(head.value + " -> ");
		recursiveInOrderNode(head.right);
	}

	public void recursivePostOrderNode(Node head) {
		if (head == null) {
			return;
		}
		// 左 右 根
		recursivePostOrderNode(head.left);
		recursivePostOrderNode(head.right);
		System.out.print(head.value + " -> ");
	}

	/**
	 * 非递归打印
	 * 
	 * @param head
	 */
	public void unRecursivePreNode(Node head) {
		// 先 序
		// 根 左 右
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
		// 中序 左 根 右
		Stack<Node> stack = new Stack<>();
		Node currentNode = head;

		while (!stack.isEmpty() || currentNode != null) {
			while (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			// 最后 左节点
			currentNode = stack.pop();
			System.out.print(currentNode.value + " -> ");
			currentNode = currentNode.right;
		}
	}

	/**
	 * 后序遍历第一种写法
	 * 
	 * @param head
	 */
	public void unRecursivePostOrderNode(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		// 左 右 根
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
		Node h = head;// 最近一次弹出并打印的节点
		Node c = null;// 当前栈顶节点
		stack.push(head);
		while (!stack.isEmpty()) {
			c = stack.peek();// 取栈顶第一个节点
			if (c.left != null && h != c.left && c.right != h) {
				stack.push(c.left);
			} else if (c.right != null && h != c.right) {
				stack.push(c.right);
			} else {
				// c.left 或者 c.right ==null h==c.left c.right
				System.out.print(c.value + " -> ");
				h = c;
				stack.pop();
			}
		}
	}

	/**
	 * 按层打印二叉树
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
	 * 按层换行打印
	 */
	public void layerNodeLn(Node head) {
		if (head == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		Node last = head;//当前正在打印的当前行的最右节点
		Node nLast = head;//下一行的最右节点
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
				System.out.println();// 换行
				last = nLast;
			}
		}
	}
	/**
	 * 节点序列化 方法一
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
