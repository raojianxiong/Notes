package algo.day06;

/**
 * 给定某个节点，不一定是头节点，返回给定节点的后续节点(即按中序遍历后，从小到大排序的后面一个节点) 
 * 每个parent指向的是它的父节点
 * 方法一:继续令parent = parent.parent,只要为空，则是头节点，然后中序遍历，找到比它值大的后一个节点即可 时间复杂度O(N)
 * 方法二: 如果node节点和node的后续距离为L，复杂度为O(N) 如下
 * 牢记二叉树，左边节点比父节点小，父节点比右边小
 * 搜索二叉树
 * @author Jianxiong Rao
 *
 */
public class DemoThree {

	public static DataNode findNextNode(DataNode node) {
		if(node == null) {
			return null;
		}
		DataNode currentNode = null;
		//1 node 有右子树 ，则说明右边最小的值在右子树的最左节点，找右子树的最左节点
		if(node.right != null) {
			currentNode = node.right;
			while(currentNode != null) {
				currentNode = currentNode.left;
			}
			return currentNode;
		}
		//2 node 没有右子树
		currentNode = node;
		if(node.right == null) {

			while(currentNode.parent != null) {
				currentNode = currentNode.parent;
				////3. node 是否是父节点的左孩子
				if(currentNode.left == node) {
					return currentNode;
				}
					//4. node 不是父节点的左孩子
					
				
			}
		}
		return currentNode;
	}
}
