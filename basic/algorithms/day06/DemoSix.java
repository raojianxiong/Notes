package algo.day06;

/**
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，
 * 当到达节点B时，路径上的节点数叫做A到B的距离，对于给定的一棵二叉树，
 * 求整棵树上节点间的最大距离 
 * @author Jianxiong Rao
 *
 */
public class DemoSix {

	public static int lognestDistance(Node head) {
		if(head == null) {
			return 0;
		}
		int distance = postOrderFindLongest(head);
		return distance;
	}
	/**
	 * int[] leftDistance/rightDistance 
	 * 0 节点 左孩子树上最大距离 1左孩子树上距离节点左孩子的最远距离
	 * @param root
	 * @return
	 */
	private static int postOrderFindLongest(Node root) {
		if(root == null) {
			return 0;
		}

		int leftDistance ,rightDistance;
		leftDistance = postOrderFindLongest(root.left);
		rightDistance = postOrderFindLongest(root.right);
		
		int r1 = ((leftDistance > rightDistance) ?leftDistance :rightDistance) + 1;
		//node节点的左孩子 距离左孩子最远距离  + 1 = 到node节点的距离，右节点类似，所以+2?
		int r2 = ((leftDistance + rightDistance +2)> r1 )?(leftDistance + rightDistance + 2):r1;
		return r2;
	}
}
