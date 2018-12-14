package algo.day04;

public class Node {
	public Node previous;
	public Node next;
	public Node rand;
	public int value;

	public Node(int value) {
		this.value = value;
	}
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;

	}

	public Node(int value, Node previous, Node next) {
		this.previous = previous;
		this.next = next;
		this.value = value;
	}
}
