package algo.day06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DemoTwo {

	/**
	 * 方法一
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
	 * 方法二 平衡二叉树特性: 空树是平衡二叉树 左子树与右子树高度不超过1
	 * 
	 * @param head
	 * @return
	 */
	public static boolean isBalanceBinaryTree(Node head) {
		if (head == null) {
			return true;
		}
		// 比较左子树的高度和右子树的高度
		boolean res = true;
		getHeight(head, 1, res);
		return res;

	}

	private static int getHeight(Node node, int level, boolean res) {
		if (node == null) {
			return level;
		}
		int lH = getHeight(node.left, level, res);
		// res代表 左子树或者右子树是否为平衡二叉树，false 则不需要判断另一子树了，直接返回
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
	 * 搜索二叉树 头节点比左节点大，比右节点小 中序遍历 左 根 右
	 * 每次弹出节点时比较与之前节点值的大小
	 * @param head
	 * @return
	 */
	public static boolean isSearchBinaryTree(Node head) {
		if (head == null) {
			return false;
		}
		int pre = head.value,current = head.value;// pre 前个节点的大小 current 当前节点大小
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
			currentNode = stack.pop();//栈顶元素
			current = currentNode.value;
			System.out.print(currentNode.value + " -> ");
			currentNode = currentNode.right;
			
		}
		return true;
	}
	/**
	 * 判断是否是完全二叉树
	 * 除了最后一层外，其它每一层的节点都是满的，最后一层如果也满了就是满二叉树，如果不是，则缺少的节点也全部集中在右边，即节点都在左边
	 */
	public static boolean isPrefectBinaryTree(Node head) {
		if(head == null) {
			return false;
		}
		//按层遍历
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		Node currentNode =null;
		while(!queue.isEmpty()) {
			currentNode = queue.poll();
			// 1. 当前节点有右孩子 没有左孩子
			if(currentNode.right != null && currentNode.left == null) {
				return false;
			}
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
			
			// 2.如果左孩子 和 右 孩子 并不是都有，即没有右孩子，或者没有左孩子都不需要入队了,则判断接下来的倒数第二层上的续节点，查看是否全都是叶子节点
			//根据完全二叉树的性质，叶子节点都集中在左侧
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
