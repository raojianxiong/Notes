package algo.day05;


/**
 * 如果更快的求一个整数k的n次方，如果两个整数相乘并得到结果的时间复杂度为O(1), 得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 * 给定k和n,请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值 ，2，3 返回 8
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoSix {

	/**
	 * 以10^13为例，首先我们将13以二进制表示如下 0000 1101 10^13 = 10^1 * 10^4 * 10^8 我们根据二进制的长度，依次获取
	 * 10^1 10^2 = 10^1 * 10^1 10^4 = 10^2 * 10^2 10^8 = 10^4 * 10^4; ...
	 * 1.1000000007是一个质数 2.int32位的最大值为2147483647，所以对于int32位来说1000000007足够大
	 * 3.int64位的最大值为2^63-1，对于1000000007来说它的平方不会在int64中溢出
	 * 所以在大数相乘的时候，因为(a∗b)%c=((a%c)∗(b%c))%c，所以相乘时两边都对1000000007取模，再保存在int64里面不会溢出
	 * 
	 * @param k
	 * @param n
	 * @return
	 */
	public static int multiplication(int k, int n) {
		if (n == 0) {
			return 1;
		}
		if (k == 0) {
			return 0;
		}

		if (n == 1) {
			return k;
		}
		long temp = k;
		long res = 1;
		long mod = 1000000007;
		for (; n > 0; n >>= 1) {
			if ((n & 1) != 0) {
				res = res * temp;
			}
			temp = (temp * temp) %mod;
			res = res % mod;
		}
		return (int)res;
	}
}
