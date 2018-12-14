package algo.day05;


import algo.day04.Node;

/**
 * 给定一棵完全二叉树的根节点root,返回这棵树的节点个数，如果完全二叉树的节点数为N，
 * 请实现时间复杂度低于O（N）的解法，给定树的根节点root,请返回树的大小
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoFive {

	/**
	 * 高度为h的满二叉树，节点为 2 的h次方 - 1
	 * @param head
	 * @return
	 */
	public static int countTree(Node head) {
		if (head == null) {
			return 0;
		}
		int lengthOfLeft = depthTree(head.previous);
		int lengthOfRight = depthTree(head.next);
		if(lengthOfLeft == lengthOfRight) {//左子树一定是满二叉树，左子树加上根节点 2 ^ n - 1 + 1
			return (int) (Math.pow(2,lengthOfLeft) + countTree(head.next));
		}else {
			return (int) (Math.pow(2, lengthOfRight) + countTree(head.previous));
		}

	}
	/**
	 * node节点的层数
	 * @param node
	 * @return
	 */
	private static int depthTree(Node node) {
		if(node == null) {
			return 0;
		}
		int len = 0;
		Node p = node;
		while(p != null) {
			len ++;
			p = p.previous;
		}
		return len;
	}
}
