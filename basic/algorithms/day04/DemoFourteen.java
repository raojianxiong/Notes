package algo.day04;

/**
 * ���������������ͷ�ڵ�head1��head2������ж����������Ƿ��ཻ��
 * �ཻ�Ļ�����true,���ཻ�Ļ�����false,
 * �������������ͷ�ڵ�head1��head2(ע�⣬������������adjust0��adjust1���ڵ������ݣ��뱾������޹�)��
 * �뷵��һ��boolֵ���������Ƿ��ཻ��
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoFourteen {

	public static boolean isIntersect(Node head1,Node head2,int adjust0,int adjust1) {
		if(head1 == null || head2 == null) {
			return false;
		}
		// 1. �ж��Ƿ��л���һ���л� һ���޻�
		Node isHead1Circle = DemoEleven.checkLoopNode(head1, adjust0);
		Node isHead2Circle = DemoEleven.checkLoopNode(head2, adjust1);
		//2.һ���л�����һ���޻� �϶����ཻ
		if(isHead1Circle == null && isHead2Circle != null) {
			return false;
		}
		if(isHead1Circle != null && isHead2Circle == null) {
			return false;
		}
		
		//3.������û��
		if(isHead1Circle == null && isHead2Circle == null) {
			return DemoTwelve.checkIntersect(head1, head2);
		}
		//4.�������л�
		if(isHead1Circle != null && isHead2Circle != null) {
			Node node = DemoThirteen.checkIntersect(head1, head2, adjust0, adjust1);
			if(node != null) {
				return true;
			}
		}
		return false;
	}
}
