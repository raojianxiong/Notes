package algo.day04;
/**
 * ����һ����������
 * (ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ����һ��) 
 * @author Jianxiong Rao
 *
 */
public class DemoEight {

	public Node copyNode(Node head) {
		if(head == null || head.next == null) {
			return null;
		}
		Node currentNode = head;
		//1.���ȸ��ƽڵ㣬ÿ���ڵ�copyһ��node���뵽����
		while(currentNode != null) {
			Node node = new Node(currentNode.value);
			node.next = currentNode.next;
			currentNode.next  = node;
		}
		//2.ÿ��copy��node�ڵ�ָ��rand�ڵ����һ���ڵ�
		currentNode  = head;
		while(currentNode != null ) {//����˵��randΪ����ڵ�
			currentNode.next.rand   = currentNode.rand.next;
			currentNode = currentNode.next.next;
		}
		
		//Ȼ���ֳ���
		Node newHead = head.next;
		currentNode = head;
		Node newCurrentNode = newHead;
		while(currentNode != null && newCurrentNode != null) {
			currentNode.next = currentNode.next.next;
			newCurrentNode.next = newCurrentNode.next.next;
			currentNode = currentNode.next;
			newCurrentNode = newCurrentNode.next;
		}
		return newHead;
	}
}
