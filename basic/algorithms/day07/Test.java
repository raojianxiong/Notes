package algo.day07;

public class Test {
	public static void main(String[] args) {
		int[] data = DemoOne.oddApperance2(new int[] { 6, 2, 3, 3, 2, 2 }, 6);
		for (int a : data) {
			System.out.println(a);
		}
		int a = DemoOne.addPlus(3, 5);
		System.out.println(" + -> "+ a);
	}
}
