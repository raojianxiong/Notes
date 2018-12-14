package algo.day01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import algo.day01.DoubleTree.Node;

public class Test {
	public static void main(String[] args) {

	}

	/**
	 * �ǵݹ� �ݹ�Ļ�ֱ�ӵ��ô�ӡ���Ϳ�����
	 *  key - value ģʽ�Ļ� key�µ�valueΪ����#! 
	 *  key ģʽ �������
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
	 * ����������ݹ�
	 * 
	 * @param data
	 * @return
	 */
	public Node unSerialize(String data) {
		Node node = null;
		if ("".equals(data) || data.startsWith("#!")) {
			// ����������ƥ��
			return null;
		}
		String[] result = data.split("!");
		node = deSerialize(result);
		return node;
	}

	int index = 0;

	/**
	 * �ݹ�
	 * �ǵݹ� ���ö��л���ջ ÿ�η�ʣ�µ��ַ���
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
