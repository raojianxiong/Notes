package algo.day06;

/**
 * ����ĳ���ڵ㣬��һ����ͷ�ڵ㣬���ظ����ڵ�ĺ����ڵ�(������������󣬴�С��������ĺ���һ���ڵ�) 
 * ÿ��parentָ��������ĸ��ڵ�
 * ����һ:������parent = parent.parent,ֻҪΪ�գ�����ͷ�ڵ㣬Ȼ������������ҵ�����ֵ��ĺ�һ���ڵ㼴�� ʱ�临�Ӷ�O(N)
 * ������: ���node�ڵ��node�ĺ�������ΪL�����Ӷ�ΪO(N) ����
 * �μǶ���������߽ڵ�ȸ��ڵ�С�����ڵ���ұ�С
 * ����������
 * @author Jianxiong Rao
 *
 */
public class DemoThree {

	public static DataNode findNextNode(DataNode node) {
		if(node == null) {
			return null;
		}
		DataNode currentNode = null;
		//1 node �������� ����˵���ұ���С��ֵ��������������ڵ㣬��������������ڵ�
		if(node.right != null) {
			currentNode = node.right;
			while(currentNode != null) {
				currentNode = currentNode.left;
			}
			return currentNode;
		}
		//2 node û��������
		currentNode = node;
		if(node.right == null) {

			while(currentNode.parent != null) {
				currentNode = currentNode.parent;
				////3. node �Ƿ��Ǹ��ڵ������
				if(currentNode.left == node) {
					return currentNode;
				}
					//4. node ���Ǹ��ڵ������
					
				
			}
		}
		return currentNode;
	}
}
