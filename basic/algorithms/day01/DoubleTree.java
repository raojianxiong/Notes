package algo.day01;

import java.util.LinkedList;
import java.util.Queue;


/**
 * ������ key ģʽ
 * 
 * @author Jianxiong Rao
 *
 */
public class DoubleTree {
//	private int[] data;
	private int n;
	private Node root;
	// private int index;
	private int count;

	public DoubleTree(int capacity) {
		// data = new int[capacity];
		n = capacity;
		// index = 0;
	}

	// ���������뵽�����У���ӵ���β ���Ԫ��
	public void insertElement(int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			root = insert(root, value);
		}

	}
	
	//��ӡ������
	public void printAll() {
		printNode(root);
	}
	//���кŻ��д�ӡ������,�������
	private void printByLineNumber() {
		Node last = root;
		Node nLast = root;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.value +"\t");
			if(node.left != null) {
				queue.add(node.left);
				nLast = node.left;
			}
			if(node.right != null) {
				queue.add(node.right);
				nLast = node.right;
			}
			if(last == node) {
				System.out.println();
				last = nLast;//������һ�ε����ҽڵ�
			}
		}
	}
	
	//�ݹ�򵥴�ӡ
	private void printNode(Node node) {
		if(node != null) {
			//���� ������
			System.out.print(node.value +"\t");
			printNode(node.left);
			printNode(node.right);
			//���� �����
//			printNode(node.left);
//			System.out.print(node.value +"\t");
//			printNode(node.right);
			//���� ���Ҹ�
//			printNode(node.left);
//			printNode(node.right);
//			System.out.print(node.value +"\t");
		}
	}

	private boolean insertTwo(int value) {
		/**
		 * �ǵݹ�ʵ�֣��ҵ����ڵ�
		 */
		if(root == null) {
			root = new Node(value);
			return true;
		}
		Node currentNode = root;
		Node parent = null;
		while (currentNode != null) {
			if (currentNode.value > value) {

				// ���뵽������
				parent = currentNode;
				currentNode = currentNode.left;

			} else if (currentNode.value < value) {
				parent = currentNode;
				currentNode = currentNode.right;
			}else {
				return false;
			}
		}
		if (parent.value > value) {
			parent.left = new Node(value);
		} else {
			parent.right = new Node(value);
		}
		return true;
	}

	// ��Ҫ���ĸ��ڵ���뵽�ĸ�����
	private Node insert(Node node, int value) {
		if (node == null) {
			count++;
			return new Node(value);
		}
		if (value == node.value) {
			// ����
		} else if (value < node.value) {
			insert(node.left, value);
		} else if (value > node.value) {
			insert(node.right, value);
		}

		return node;
	}
	

	public static class Node {
		// private int key;
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			// this.key = key;
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
		public Node getRightNode() {
			return this.right;
		}
		public Node getLeftNode() {
			return this.left;
		}
		public void setRightNode(Node right) {
			this.right = right;
		}
		public void setLeftNode(Node left) {
			this.left = left;
		}

	}
}
