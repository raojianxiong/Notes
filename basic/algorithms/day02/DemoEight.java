package algo.day02;

import javax.swing.tree.TreeNode;

import algo.day01.DoubleTree.Node;

/**
 * �������ñ˴˶����Ķ�����A��B�����дһ����Ч�㷨��
 * ���A���Ƿ����һ��������B�������˽ṹ��ȫ��ͬ���������ö�������ͷ�ڵ�A��B��
 * �뷵��һ��booleanֵ������A���Ƿ����һ��ͬ����B��������
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
	 * �������
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
