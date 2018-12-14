package algo.day02;

import java.util.Random;

/**
 * 跳表 存储的都是正整数，并且存储的是不重复的 二分查找
 * 跳表高度 log k N k为每k个元素提取一个节点
 * @author Jianxiong Rao
 *
 */
public class SkipList {

	private static final int MAX_LEVEL = 16;
	private int levelCount = 1;
	private Node head = new Node();// 带头链表

	private Random r = new Random();

	/**
	 * 查找
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
		Node update[] = new Node[level];//k层，那么就有k列，记录每行的转折点
		//默认第一列都是head节点
		for(int i = 0;i<level; ++i) {
			update[i]= head; 
		}
		Node p = head;
		for(int i = level - 1;i>=0; --i) {
			//每一行，从左到右开始找，每行中找到第一个大于value的前一个位置
			while(p.forwords[i]!= null && p.forwords[i].data < value  ) {
				p = p.forwords[i];
			}
			update[i]= p; 
		}
		//更新指向，之前指的赋值给newValue，然后update再指向newValue
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
			//需要将每行指向的后一个节点指向摆正
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
		//这里存的是每一行的后一个节点
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
