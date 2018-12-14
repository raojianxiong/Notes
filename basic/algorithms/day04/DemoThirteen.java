package algo.day04;

/**
 * ����ж������л��������Ƿ��ཻ���ཻ�Ļ����ص�һ���ཻ�Ľڵ㣬 ���ཻ�Ļ����ؿգ�������������ȷֱ�ΪN��M��������ʱ�临�Ӷ�ΪO(N+M),
 * ����ռ临�Ӷ�O(1)���������������ͷ�ڵ�head1��head2(ע�⣬������������adjust0��djust1���ڵ������ݣ��뱾������޹�)��
 * �뷵��һ��boolֵ���������Ƿ��ཻ��
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoThirteen {

	/**
	 * �����������л�������
	 * 
	 * @param head1
	 * @param head2
	 */
	public static Node checkIntersect(Node head1, Node head2, int adjust0, int adjust1) {
		// 1. ���ҵ������뻷�Ľڵ�
		Node loop1 = DemoEleven.checkLoopNode(head1, adjust0);
		Node loop2 = DemoEleven.checkLoopNode(head2, adjust1);
		if (loop1 == null || loop2 == null) {
			return null;
		}
		// 2. �����뻷�ڵ�һ�� ,˵���л� ,��������֮ǰ���Ѿ��ཻ�ˣ���Ҫ�ҵ���һ���ཻ�Ľڵ�,�Ǿ��Ǵ��׽ڵ㿪ʼ�ң���ֹ����Ϊ�뻷�ڵ�
		if (loop1 == loop2) {
			Node node = DemoTwelve.checkIntersectLoop(head1, head2, loop1);
			if (node == null) {
				return loop1;
			} else {
				return node;
			}
		}else {
			//3.����뻷�㲻һ�� ,�����ǴӲ�ͬ�ĵ��뻷
			Node p = loop1.next;
			while(p!=null) {
				if(p == loop2) {
					return p;
				}
				p = p.next;
			}
		}
		return null;
	}
}
