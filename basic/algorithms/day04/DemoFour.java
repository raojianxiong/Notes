package algo.day04;
/**
 * �����������������������о����ظ�Ԫ�أ������һ����Ч���㷨��
 * ��ӡ��������Ĺ���ֵ���֣��������������ͷָ��headA��headB,�뷵��һ��vertor,
 * Ԫ��Ϊ��������Ĺ������֣��뱣֤���ص�������������������Ԫ�ظ�����С�ڵ���500.
 * ��֤һ���й���ֵ��[1,2,3,4,5,6,7],[2,4,6,8,10] ���� [2,4,6] 
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
				//����һ���üǵ��ƶ�
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
