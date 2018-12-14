package algo.day01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import algo.day01.DoubleTree.Node;

public class Test {
	public static void main(String[] args) {

	}

	/**
	 * 非递归 递归的话直接调用打印语句就可以了
	 *  key - value 模式的话 key下的value为空则#! 
	 *  key 模式 先序遍历
	 * 
	 * @param node
	 * @return
	 */
	public String serialize(Node node) {
		StringBuilder sb = new StringBuilder();

		if (node == null) {
			sb.append("#!");
		} else {
			Stack<Node> stack = new Stack<>();
			stack.push(node);
			while (!stack.isEmpty()) {
				Node currentNode = stack.pop();
				if (currentNode == null) {
					sb.append("#!");
				} else {
					sb.append(currentNode.getValue() + "!");

					stack.add(currentNode.getRightNode());
					stack.add(currentNode.getLeftNode());
				}

			}
		}
		return sb.toString();
	}

	/**
	 * 先序遍历反递归
	 * 
	 * @param data
	 * @return
	 */
	public Node unSerialize(String data) {
		Node node = null;
		if ("".equals(data) || data.startsWith("#!")) {
			// 可以用正则匹配
			return null;
		}
		String[] result = data.split("!");
		node = deSerialize(result);
		return node;
	}

	int index = 0;

	/**
	 * 递归
	 * 非递归 采用队列或者栈 每次放剩下的字符串
	 * @param result
	 * @return
	 */
	public Node deSerialize(String[] result) {
		if ("#".equals(result[index])) {
			++index;
			return null;
		} else {
			Node newNode = new Node(Integer.parseInt(result[index]));
			++index;
			newNode.setLeftNode(deSerialize(result));
			newNode.setRightNode(deSerialize(result));
			return newNode;
		}
	}
}
