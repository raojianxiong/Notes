package algo.day04;

public class Test {
	public static void main(String[] args) {
		System.out.println("Demo One");
		DemoOne one = new DemoOne();
		for (int i : one.insert(new int[] { 1, 3, 4, 5, 7 }, new int[] { 1, 2, 3, 4, 0 }, 2)) {
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.println("Demo Three");
		DemoThree three = new DemoThree();
		for (int i : three.convertNodes(new int[] { 1, 4, 2, 5 }, 3)) {
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.println("Demo Four");
		DemoFour four = new DemoFour();
		for (int i : four.common(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 2, 4, 6, 8, 10 })) {
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.println("Demo Five");
		DemoFive five = new DemoFive();
		for (int i : five.reverseNode(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 3)) {
			System.out.print(i + " -> ");
		}
		System.out.println();
		System.out.println("Demo Five");

		for (int i : five.reverseByStack(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 3)) {
			System.out.print(i + " -> ");
		}
		System.out.println();
		System.out.println("Demo Six");
		DemoSix six = new DemoSix();
		for (int i : six.deleteNode(new int[] { 1, 2, 3, 4, 3, 1, 2 }, 3)) {
			System.out.print(i + " -> ");
		}
		System.out.println();
		System.out.println("Demo Seven");
		DemoSeven seven = new DemoSeven();
		boolean isPalindrome = seven.isPalindrome(new int[] { 1, 2, 3, 4, 3,2, 1 });
		System.out.print("Demo Seven is Palindrome ->  " + isPalindrome);
		System.out.println();
		boolean isPalindrome2 = seven.isPalindrome2(new int[] { 1, 2, 3, 4, 3,2, 1 });
		System.out.print("Demo Seven is Palindrome2 ->  " + isPalindrome2);

	}
}
