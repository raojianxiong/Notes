package algo.day03;

public class Test {
	public static void main(String[] args) {
		DemoOne one = new DemoOne();
		one.push(2);
		one.push(4);
		one.push(6);
		one.push(1);
//		one.pop();
		System.out.println("×îÐ¡Öµ -> " + one.getMin());
		for (int i : (new DemoTwo()).twoStack(new int[] { 1, 2, 3, 0, 4, 0 }, 6)) {
			System.out.print(i + "\t");
		}
		System.out.println("===");
		for (int i : (new DemoThree()).reverseStack(new int[] {4,3,2,1 }, 4)) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for (int i : (new DemoFour()).sort(new int[] { 100, 2, 6, 4, 5 })) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for (int i : (new DemoFive()).slid((new int[] { 4, 3, 5, 4, 3, 3, 6, 7 }), 8, 3)) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for (int i : (new DemoSix()).buildMaxTree((new int[] {3,1,4,2 }), 4)) {
			System.out.print(i + "\t");
		}
	}
}
