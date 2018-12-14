package algo.day06;

public class DataNode {
	public DataNode parent;
	public DataNode left;
	public DataNode right;
	public int value;
	public DataNode() {
		
	}
	public DataNode(int value,DataNode left,DataNode right,DataNode parent) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
}
