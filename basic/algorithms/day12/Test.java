package algo.day12;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] result = DemoOne.printMatrix(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
		for(int info:result) {
			System.out.print(info + "\t");
		}
		System.out.println("Demo Two ---- >>>> ");
		int result2 = DemoTwo.findMedianLogn(new int[] {1,2,3}, 0, 2, new int[] {4,4,5}, 0, 2);
		System.out.println("中位数 -> "+ result2);
		System.out.println("Demo Two -->>");
		int result3 = DemoTwo.findKthSmallest(new int[] {1,2,3}, 3, new int[] {4,4,5}, 3, 6);
		System.out.println("第 2 小的元素 -> "+ result3);
	}
	

}
