package algo.day06;


/**
 * 有一棵二叉树，其中所有节点的值都不一样，找到含有节点最多的搜索二叉子树，
 * 并返回这棵子树的头节点。给定二叉树的头节点root,请返回所求的头节点，如果出现多个头节点， 则返回权值最大的
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoSeven {

	public static Node getMax(Node root) {
		int[] record = new int[3];

		return postOrderGetMax(root, record);
	}

	/**
	 * 1.整个过程使用后序遍历
	 * 
	 * 2.遍历到当前节点记为cur时，先遍历cur的左子树收集4个信息，
	 * 分别是左子树上最大搜索二叉子树的头节点(lBST)、节点数(lSize)、最小值(lMin)和最大值(lMax)。
	 * 再遍历cur的右子树收集4个信息，分别是右子树上最大搜索二叉子树的头节点(rBST)、节点数(rSize)、最小值(rMin)和最大值(rMax)
	 * 
	 * 3.根据步骤2所收集的信息，判断是否满足搜索子树的定义，如果满足就返回cur节点， 
	 *  如果不满足就返回lBST和rBST中节点数多的那一个
	 * 
	 * @param root
	 * @param record
	 * @return
	 */
	private static Node postOrderGetMax(Node root, int[] record) {
		// 递归边界：NULL。递归用到的计数，都是从递归边界开始的！所以写递归时一定要先写好递归边界的返回情况
		if (root == null) {
			record[0] = 0;// Null结点的最大二叉搜索子树结点数为0   节点数
			record[1] = Integer.MAX_VALUE;// Null结点，子树最小值不存在，所以令为最大值   最小值 
			record[2] = Integer.MIN_VALUE;// Null结点，子树最大值不存在，所以令为最小   最大值
			return null;
		}
		int value = root.value;
		Node left = root.left;
		Node right = root.right;
		
		Node lBST = postOrderGetMax(left, record);
		int lSize = record[0];
		int lMin = record[1];
		int lMax = record[2];
		
		Node rBST = postOrderGetMax(right, record);
		int rSize = record[0];
		int rMin = record[1];
		int rMax = record[2];
		
		record[1] = Math.min(lMin, value);// 之前最小值 和当前节点比较
		record[2] = Math.max(rMax, value); //之前最大值 和 当前节点比较
		//如果左边和右边都是搜索二叉树 , 那么直接这样
		if(left == lBST && right==rBST && lMax <= value && rMin >= value) {
			record[0] = lSize + rSize + 1;
			return root;
		}
		//否则的话 直接选最大的那边
		record[0] = Math.max(lSize, rSize);
		return lSize > rSize ? lBST:rBST;

	}
}
