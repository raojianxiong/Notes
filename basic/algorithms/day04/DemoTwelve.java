package algo.day04;

/**
 * �����������޻�����������������ĳ��ȷֱ�Ϊm��n,�����һ��ʱ�临�Ӷ�ΪO(M+N), ����ռ临�Ӷ�ΪO(1)���㷨��
 * �ж������������Ƿ��ཻ���������������ͷ�ڵ�headA��headB�� �뷵��һ��boolֵ�����������������Ƿ��ཻ����֤��������ĳ���С�ڵ���500
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoTwelve {

	/**
	 * �������������ţ�������һ��������û����ͬ�ڵ㣬û�еĻ��Ǿ�û��
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static boolean checkIntersect(Node headA, Node headB) {
		if (headA == null || headB == null) {
			return false;
		}
		// 1.����ཻ����ô�ཻ��Ľڵ����һ������,����M > N��������Ҫ�� �ȱ���M -N +1���ڵ�,Ȼ���ٱȽ�
		int numA = 0;
		Node currentNode = headA;
		while (currentNode != null) {
			numA++;
			currentNode = currentNode.next;
		}
		int numB = 0;
		currentNode = headB;
		while (currentNode != null) {
			numB++;
			currentNode = currentNode.next;
		}
		currentNode = headA;
		Node currentHeadBNode = headB;
		int offset = 0;
		boolean isNodeA = false;
		if (numA > numB) {
			offset = numA - numB + 1;
			isNodeA = true;
		} else {
			offset = numB - numA + 1;
		}

		int j = 1;
		while (j < offset) {
			j++;
			if (isNodeA) {
				currentNode = currentNode.next;
			} else {
				currentHeadBNode = currentHeadBNode.next;
			}
		}

		
		while(currentHeadBNode != null && currentNode != null) {
			if(currentHeadBNode == currentNode) {
				return true;
			}
			currentHeadBNode =  currentHeadBNode.next;
			currentNode = currentNode.next;
		}
		return false;
	}
	/**
	 * �л�������ʱ �ж����������뻷�ڵ㴦֮ǰ�Ƿ����ཻ�ڵ�
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static Node checkIntersectLoop(Node headA, Node headB,Node stopNode) {
		
		// 1.����ཻ����ô�ཻ��Ľڵ����һ������,����M > N��������Ҫ�� �ȱ���M -N +1���ڵ�,Ȼ���ٱȽ�
		int numA = 0;
		Node currentNode = headA;
		while (currentNode != null) {
			numA++;
			currentNode = currentNode.next;
		}
		int numB = 0;
		currentNode = headB;
		while (currentNode != null) {
			numB++;
			currentNode = currentNode.next;
		}
		currentNode = headA;
		Node currentHeadBNode = headB;
		int offset = 0;
		boolean isNodeA = false;
		if (numA > numB) {
			offset = numA - numB + 1;
			isNodeA = true;
		} else {
			offset = numB - numA + 1;
		}

		int j = 1;
		while (j < offset) {
			j++;
			if (isNodeA) {
				currentNode = currentNode.next;
			} else {
				currentHeadBNode = currentHeadBNode.next;
			}
		}

		
		while(currentHeadBNode != stopNode && currentNode != stopNode) {
			if(currentHeadBNode == currentNode) {
				return currentHeadBNode;
			}
			currentHeadBNode =  currentHeadBNode.next;
			currentNode = currentNode.next;
		}
		return null;
	}
}
