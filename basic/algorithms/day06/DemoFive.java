package algo.day06;

import java.util.Stack;

import javafx.scene.chart.PieChart.Data;

/**
 * һ�ö�����ԭ�������������������������������ڵ������λ�ã�ʹ����ö�����������������������
 * ���ҵ��������ڵ㣬���������ǵ�ֵ��
 * �������нڵ��ֵ������ͬ����������������λ�õ�ֵ������С��ֵ��ǰ�档
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
			if(last > now) {//��ǰ�ڵ�ֵ��ǰһ���Ƚ�
				result[0] = now;
				result[1] = last;
				stackArray.push(result);
			}
			last = now;
			currentNode = currentNode.right;
		}
		while(stackArray.size() != 1) {
			int[] back = stackArray.pop();
			result[1] = back[1];//��һ������Ľڵ�
			back = stackArray.pop();
			result[0] = back[0];//�ڶ�������Ľڵ� ����ڵ�ֵ�Ƚ�С
		}
		return result;
	}
}
