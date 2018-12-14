package algo.day06;


/**
 * ��һ�ö��������������нڵ��ֵ����һ�����ҵ����нڵ�������������������
 * ���������������ͷ�ڵ㡣������������ͷ�ڵ�root,�뷵�������ͷ�ڵ㣬������ֶ��ͷ�ڵ㣬 �򷵻�Ȩֵ����
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoSeven {

	public static Node getMax(Node root) {
		int[] record = new int[3];

		return postOrderGetMax(root, record);
	}

	/**
	 * 1.��������ʹ�ú������
	 * 
	 * 2.��������ǰ�ڵ��Ϊcurʱ���ȱ���cur���������ռ�4����Ϣ��
	 * �ֱ����������������������������ͷ�ڵ�(lBST)���ڵ���(lSize)����Сֵ(lMin)�����ֵ(lMax)��
	 * �ٱ���cur���������ռ�4����Ϣ���ֱ����������������������������ͷ�ڵ�(rBST)���ڵ���(rSize)����Сֵ(rMin)�����ֵ(rMax)
	 * 
	 * 3.���ݲ���2���ռ�����Ϣ���ж��Ƿ��������������Ķ��壬�������ͷ���cur�ڵ㣬 
	 *  ���������ͷ���lBST��rBST�нڵ��������һ��
	 * 
	 * @param root
	 * @param record
	 * @return
	 */
	private static Node postOrderGetMax(Node root, int[] record) {
		// �ݹ�߽磺NULL���ݹ��õ��ļ��������Ǵӵݹ�߽翪ʼ�ģ�����д�ݹ�ʱһ��Ҫ��д�õݹ�߽�ķ������
		if (root == null) {
			record[0] = 0;// Null�����������������������Ϊ0   �ڵ���
			record[1] = Integer.MAX_VALUE;// Null��㣬������Сֵ�����ڣ�������Ϊ���ֵ   ��Сֵ 
			record[2] = Integer.MIN_VALUE;// Null��㣬�������ֵ�����ڣ�������Ϊ��С   ���ֵ
			return null;
		}
		int value = root.value;
		Node left = root.left;
		Node right = root.right;
		
		Node lBST = postOrderGetMax(left, record);
		int lSize = record[0];
		int lMin = record[1];
		int lMax = record[2];
		
		Node rBST = postOrderGetMax(right, record);
		int rSize = record[0];
		int rMin = record[1];
		int rMax = record[2];
		
		record[1] = Math.min(lMin, value);// ֮ǰ��Сֵ �͵�ǰ�ڵ�Ƚ�
		record[2] = Math.max(rMax, value); //֮ǰ���ֵ �� ��ǰ�ڵ�Ƚ�
		//�����ߺ��ұ߶������������� , ��ôֱ������
		if(left == lBST && right==rBST && lMax <= value && rMin >= value) {
			record[0] = lSize + rSize + 1;
			return root;
		}
		//����Ļ� ֱ��ѡ�����Ǳ�
		record[0] = Math.max(lSize, rSize);
		return lSize > rSize ? lBST:rBST;

	}
}
