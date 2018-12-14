package algo.day04;
/**
 * 输入一个复杂链表
 * (每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向另一个) 
 * @author Jianxiong Rao
 *
 */
public class DemoEight {

	public Node copyNode(Node head) {
		if(head == null || head.next == null) {
			return null;
		}
		Node currentNode = head;
		//1.首先复制节点，每个节点copy一个node插入到后面
		while(currentNode != null) {
			Node node = new Node(currentNode.value);
			node.next = currentNode.next;
			currentNode.next  = node;
		}
		//2.每个copy的node节点指向rand节点的下一个节点
		currentNode  = head;
		while(currentNode != null ) {//题中说了rand为任意节点
			currentNode.next.rand   = currentNode.rand.next;
			currentNode = currentNode.next.next;
		}
		
		//然后拆分出来
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
