package algo.day04;
/**
 * 现有两个升序链表，且链表中均无重复元素，请设计一个高效的算法，
 * 打印两个链表的公共值部分，给定两个链表的头指针headA和headB,请返回一个vertor,
 * 元素为两个链表的公共部分，请保证返回的数组的升序，两个链表的元素个数均小于等于500.
 * 保证一定有公共值。[1,2,3,4,5,6,7],[2,4,6,8,10] 返回 [2,4,6] 
 * @author Jianxiong Rao
 *
 */
public class DemoFour {

	public int[] common(int[] A,int[] B) {
		if(A == null || B == null) {
			return null;
		}
		Node headA = new Node(A[0]);
		Node headB = new Node(B[0]);
		Node currentNode = headA;
		for(int i = 1;i<A.length;i++) {
			Node newNode = new Node(A[i]);
			currentNode.next = newNode;
			currentNode = currentNode.next;
		}
		currentNode = headB;
		for(int i = 1;i<B.length;i++) {
			Node newNode = new Node(B[i]);
			currentNode.next = newNode;
			currentNode = currentNode.next;
		}
		
		Node commonNode = null;
		int i = 0;
		while(headA != null && headB != null) {
			if(headA.value  == headB.value) {
				if(commonNode == null) {
					commonNode = new Node(headA.value);
					currentNode = commonNode;
				}else {
					currentNode.next = new Node(headA.value);
					currentNode = currentNode.next;
				}
				i++;
				//这里一定得记得移动
				headA = headA.next;
				headB = headB.next;
			}else if(headA.value > headB.value) {
				headB = headB.next;
			}else {
				headA = headA.next;
			}
		}
		int[] data = new int[i];
		int j = 0;
		while(commonNode != null) {
			data[j]= commonNode.value;
			j++;
			commonNode = commonNode.next;
		}
		
		return data;
	}
}
