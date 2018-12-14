package algo.day07;

public class DemoOne {

	/**
	 * 交换两个数
	 * 
	 * @param a
	 * @param b
	 */
	public static void swapValue(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(" a - > " + a);
		System.out.println(" b - > " + b);
	}

	/**
	 * 对于两个32位的整型a和 b，请设计一个算法返回a和b中较大的，但是不能用任何比较判断，若两数相同，返回任意一个
	 * 
	 */
	public static int compare(int a, int b) {
		int c = a - b;
		int as = sign(a);// 0代表负 1 代表正
		int bs = sign(b);
		int cs = sign(c);
		int differ = as ^ bs;
		int sam = flip(differ);
//		int returnA = differ * as + sam * bs;
//		int returnB = flip(returnA);
//		return a * returnA + b* returnB;
		if (sam == 1) {
			// 符号同
			return cs == 1 ? a : b;
		} else {
			return (as - bs) == 1 ? a : b;
		}
	}

	/**
	 * 有一个整型数组A，其中只有一个数出现了奇数次，其他的都出现了偶数次，请打印这个数，要求时间复杂度位O(N),空间复杂度位O(1)。
	 */
	public static int oddApperance1(int[] A, int n) {
		int e = 0;
		for (int i = 0; i < n; i++) {
			e = e ^ A[i];
		}
		return e;
	}

	/**
	 * 两个数是奇数 思路：先用int e去用异或去得到e，这个e是两个奇数的值的异或值； 然后再用int
	 * k，去判断e中第k为的二进制数为1的那个第k位数，因为出现两次奇数的数，肯定有一个位为1，另一个为0； 然后再用int
	 * echo，去循环一遍数组，但比对的前提条件是第K位为1的数组里面的元素；   最后找到一个位echo，另一个为 echo^e;
	 * 
	 * 我们还是从头到尾依次异或数组中的每一个数字，那么最终得到的结果就是两个只出现一次的数字的异或结果。因为其他数字都出现了两次，在异或中全部抵消掉了。由于这两个数字肯定不一样，那么这个异或结果肯定不为0，也就是说在这个结果数字的二进制表示中至少就有一位为1。我们在结果数字中找到第一个为1的位的位置，记为第N位。
	 * 现在我们以第N位是不是1为标准把原数组中的数字分成两个子数组，第一个子数组中每个数字的第N位都为1，而第二个子数组的每个数字的第N位都为0。
	 */
	public static int[] oddApperance2(int[] A, int n) {
		int e = 0;// 这两个数的异或值
		for (int i = 0; i < n; i++) {
			e = e ^ A[i];
		}
		int k = 0,temp = e;
		//从左到右 
		while( (temp & 1)  == 0) {//找到位 为 1 的位置
			k++;
			temp >>= 1;
		}
		e = 0;
		int e2 = 0;
		for( int j =0;j<n;j++) {
			if(isBit1(A[j], k)) {
				e = e ^ A[j];
			}else {
				e2 = e2 ^ A[j];
			}
		}
		if(e > e2) {
			return new int[] {e2,e};
		}
		return new int[] {e,e2};
	}

	/**
	 * 求a + b的和 ,不能使用 + 号
	 */
	public static int addPlus(int a,int b) {
		if( a ==0) return b;
		if(b ==0) return a;
		int x1 = a ^ b;//忽略进位
		int x2 = (a & b) << 1;//如果有进位，右移一位
		return addPlus(x1, x2);
	}
	/**
	 * 判断某个数第index位是不是1
	 * @param num
	 * @param index
	 * @return
	 */
	private static boolean isBit1(int num,int index) {
		num = num >> index;
		return (num & 1)==1;
	}
	private static int sign(int n) {
		return flip((n >> 31) & 1);
	}

	/**
	 * 如果是负号 1 则取反 -> 0
	 * 
	 * @param n
	 * @return
	 */
	private static int flip(int n) {
		return n ^ 1;
	}
}
