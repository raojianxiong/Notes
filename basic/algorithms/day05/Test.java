package algo.day05;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int pos = DemoOne.checkMin(new int[] {12,11,7,4,3,2,1,8,10});
		System.out.println("DemoOne");
		System.out.println("i - > "+pos);
		System.out.println("DemoTwo");
		int pos2 = DemoTwo.checkMin(new int[] {1,2,3,3,4}, 5, 4);
		System.out.println("pos -> "+ pos2);
		System.out.println("DemoThree");
		int data = DemoThree.getMin(new int[] {4,1,2,3,3}, 5);
		System.out.println("data -> "+ data);
		System.out.println("Demo Four");
		int data2 = DemoFour.checkMin(new int[] {-1,0,2,3}, 4);
		System.out.println("data 2 -> "+data2);
		System.out.println("Demo Five");
		int data3 = DemoSix.multiplication(2, 3);
		System.out.println("data 3 -> "+ data3);
	}

}
