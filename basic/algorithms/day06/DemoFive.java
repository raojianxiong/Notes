package algo.day06;

import java.util.Stack;

import javafx.scene.chart.PieChart.Data;

/**
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，
 * 请找到这两个节点，并返回他们的值，
 * 二叉树中节点的值各不相同，返回两个调换了位置的值，其中小的值在前面。
 * @author Jianxiong Rao
 *
 */
public class DemoFive {

	public static int[] findErrorNode(Node head) {
		if(head == null) {
			return new int[] {-1,-1};
		}
		int[] result = new int[2];
		int last=Integer.MIN_VALUE,now=0;
		Stack<Node> stack = new Stack<>();
		Stack<int[]> stackArray = new Stack<>();
		Node currentNode = head;
		while(!stack.isEmpty() || currentNode != null) {
			while(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			currentNode = stack.pop();
			now = currentNode.value;
			if(last > now) {//当前节点值和前一个比较
				result[0] = now;
				result[1] = last;
				stackArray.push(result);
			}
			last = now;
			currentNode = currentNode.right;
		}
		while(stackArray.size() != 1) {
			int[] back = stackArray.pop();
			result[1] = back[1];//第一个错误的节点
			back = stackArray.pop();
			result[0] = back[0];//第二个错误的节点 这个节点值比较小
		}
		return result;
	}
}
