package algo.day06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DemoTwo {

	/**
	 * ����һ
	 * 
	 * @param head
	 * @return
	 */
	public static boolean check(Node head) {
		int depth = 0;
		return isBalance(head, depth);
	}

	private static boolean isBalance(Node head, int depth) {
		if (head == null) {
			depth = 0;
			return true;
		}
		int left = 0, right = 0, differ = 0;
		if (isBalance(head.right, left) && isBalance(head.left, right)) {
			differ = left - right;
			depth = (left > right ? left : right) + 1;
			if (differ <= 1 && differ >= -1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * ������ ƽ�����������: ������ƽ������� ���������������߶Ȳ�����1
	 * 
	 * @param head
	 * @return
	 */
	public static boolean isBalanceBinaryTree(Node head) {
		if (head == null) {
			return true;
		}
		// �Ƚ��������ĸ߶Ⱥ��������ĸ߶�
		boolean res = true;
		getHeight(head, 1, res);
		return res;

	}

	private static int getHeight(Node node, int level, boolean res) {
		if (node == null) {
			return level;
		}
		int lH = getHeight(node.left, level, res);
		// res���� �����������������Ƿ�Ϊƽ���������false ����Ҫ�ж���һ�����ˣ�ֱ�ӷ���
		if (!res) {
			return level;
		}
		int rH = getHeight(node.right, level, res);
		if (!res) {
			return level;
		}
		if (lH - rH > 1) {
			res = false;
		}
		return Math.max(lH, rH);
	}

	/**
	 * ���������� ͷ�ڵ����ڵ�󣬱��ҽڵ�С ������� �� �� ��
	 * ÿ�ε����ڵ�ʱ�Ƚ���֮ǰ�ڵ�ֵ�Ĵ�С
	 * @param head
	 * @return
	 */
	public static boolean isSearchBinaryTree(Node head) {
		if (head == null) {
			return false;
		}
		int pre = head.value,current = head.value;// pre ǰ���ڵ�Ĵ�С current ��ǰ�ڵ��С
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		Node currentNode = head;
		while (!stack.isEmpty() || currentNode != null) {
			while(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			if(pre > current) {
				return false;
			}else {
				pre = current;
			}
			currentNode = stack.pop();//ջ��Ԫ��
			current = currentNode.value;
			System.out.print(currentNode.value + " -> ");
			currentNode = currentNode.right;
			
		}
		return true;
	}
	/**
	 * �ж��Ƿ�����ȫ������
	 * �������һ���⣬����ÿһ��Ľڵ㶼�����ģ����һ�����Ҳ���˾�������������������ǣ���ȱ�ٵĽڵ�Ҳȫ���������ұߣ����ڵ㶼�����
	 */
	public static boolean isPrefectBinaryTree(Node head) {
		if(head == null) {
			return false;
		}
		//�������
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		Node currentNode =null;
		while(!queue.isEmpty()) {
			currentNode = queue.poll();
			// 1. ��ǰ�ڵ����Һ��� û������
			if(currentNode.right != null && currentNode.left == null) {
				return false;
			}
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
			
			// 2.������� �� �� ���� �����Ƕ��У���û���Һ��ӣ�����û�����Ӷ�����Ҫ�����,���жϽ������ĵ����ڶ����ϵ����ڵ㣬�鿴�Ƿ�ȫ����Ҷ�ӽڵ�
			//������ȫ�����������ʣ�Ҷ�ӽڵ㶼���������
			if(currentNode.left == null || currentNode.right == null) {
				break;
			}
		}
		while(!queue.isEmpty()) {
			currentNode = queue.poll();
			if(currentNode.left != null || currentNode.right != null) {
				return false;
			}
		}
		return true;
	}
}
