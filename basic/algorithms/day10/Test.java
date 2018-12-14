package algo.day10;

public class Test {

	public static void main(String[] args) {
		int result = DemoFour.longestIncreasingSubsequence(new int[] {2,1,5,3,6,4,8,9,7}, 9);
		System.out.println("DemoFour result -> "+ result);
		int result2 = DemoSix.maxValue(new int[] {1,2,3}, new int[] {1,2,3}, 3, 6);
		System.out.println("DemoSix result -> "+ result2);
		int result3 = DemoSeven.findMinCost("abc", 3, "adc", 3, 5, 3, 100);
		System.out.println("DemoSeven result -> "+result3);
	}
}
