package algo.day02;

import java.util.Random;

/**
 * ���� �洢�Ķ��������������Ҵ洢���ǲ��ظ��� ���ֲ���
 * ����߶� log k N kΪÿk��Ԫ����ȡһ���ڵ�
 * @author Jianxiong Rao
 *
 */
public class SkipList {

	private static final int MAX_LEVEL = 16;
	private int levelCount = 1;
	private Node head = new Node();// ��ͷ����

	private Random r = new Random();

	/**
	 * ����
	 * 
	 * @param value
	 * @return
	 */
	public Node find(int value) {
		Node p = head;
		for(int i = levelCount-1;i>=0;--i) {
			while(p.forwords[i]!=null && p.forwords[i].data < value ) {
				p = p.forwords[i];
			}
		}
		if(p.forwords[0] != null && p.forwords[0].data == value) {
			return p.forwords[0];
		}else {
			return null;
		}
	}

	public void insert(int value) {
		int level = randomLevel();
		Node newNode = new Node();
		newNode.data = value;
		newNode.maxLevel = level;
		Node update[] = new Node[level];//k�㣬��ô����k�У���¼ÿ�е�ת�۵�
		//Ĭ�ϵ�һ�ж���head�ڵ�
		for(int i = 0;i<level; ++i) {
			update[i]= head; 
		}
		Node p = head;
		for(int i = level - 1;i>=0; --i) {
			//ÿһ�У������ҿ�ʼ�ң�ÿ�����ҵ���һ������value��ǰһ��λ��
			while(p.forwords[i]!= null && p.forwords[i].data < value  ) {
				p = p.forwords[i];
			}
			update[i]= p; 
		}
		//����ָ��֮ǰָ�ĸ�ֵ��newValue��Ȼ��update��ָ��newValue
		for(int i = 0;i<level;++i) {
			newNode.forwords[i] = update[i].forwords[i];
			update[i].forwords[i]= newNode;  
		}
		if(levelCount < level) {
			levelCount = level;
		}
	}
	
	public void delete(int value) {
		Node[] update = new Node[levelCount];
		Node p = head;
		for(int i = levelCount - 1;i>=0; --i) {
			while(p.forwords[i]!= null && p.forwords[i].data < value  ) {
				p = p.forwords[i];
			}
			update[i]= p; 
		}
		if(p.forwords[0] != null && p.forwords[0].data == value) {
			//��Ҫ��ÿ��ָ��ĺ�һ���ڵ�ָ�����
			for(int i = levelCount -1;i>=0;--i) {
				update[i].forwords[i]= update[i].forwords[i].forwords[i];  
			}
		}
	}
	private int randomLevel() {
		int level = 1;
		for(int i = 1;i< MAX_LEVEL; ++i) {
			if(r.nextInt() % 2 == 1) {
				level ++;
			}
		}
		return level;
	}
	public class Node {
		private int data = -1;
		//��������ÿһ�еĺ�һ���ڵ�
		private Node forwords[] = new Node[MAX_LEVEL];
		private int maxLevel = 0;

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("{ data: ");
			builder.append(data);
			builder.append("; levels: ");
			builder.append(maxLevel);
			builder.append(" }");

			return builder.toString();
		}
	}
}
