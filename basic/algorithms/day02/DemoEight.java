package algo.day02;

import javax.swing.tree.TreeNode;

import algo.day01.DoubleTree.Node;

/**
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，
 * 检查A中是否存在一棵子树与B树的拓扑结构完全相同，给定两棵二叉树的头节点A和B，
 * 请返回一个boolean值，代表A中是否存在一棵同构于B的子树。
 * @author Jianxiong Rao
 *
 */
public class DemoEight {
	public boolean checkIdentical(TreeNode A,TreeNode B ) {
		String treeA = preSerial(A);
		String treeB = preSerial(B);
		return treeA.contains(treeB);
	}
	/**
	 * 先序遍历
	 * @param node
	 * @return
	 */
	private String preSerial(TreeNode node ) {
		StringBuilder sb = new StringBuilder();
		if(node == null) {
			return "#!";
		}
		sb.append(node.value +"!");
		sb.append(preSerial(node.left));
		sb.append(preSerial(node.right));
		return sb.toString();
	}
	class TreeNode {
		// private int key;
		private int value;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int value) {
			// this.key = key;
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
		public TreeNode getRightNode() {
			return this.right;
		}
		public TreeNode getLeftNode() {
			return this.left;
		}
		public void setRightNode(TreeNode right) {
			this.right = right;
		}
		public void setLeftNode(TreeNode left) {
			this.left = left;
		}

	}
}
