package algo.day09;

import java.util.Random;

/**
 * 给定一个等概率随机生成1~5的随机函数，除此之外， 
 * 不能使用任何额外的随机机制，请实现等概率随机产生1 ~ 7的随机函数，
 * 给定一个可调用的Random5::random()方法，可以等概率产生1~5的随机函数
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoThree {

	public static int randomNumber() {
		// 1 ~ 5
		// 0 ~ 24 
		int a = 5 * (rand5() - 1) + rand5() - 1;
		while( a > 20) {
			a = 5 * (rand5() - 1) + rand5() -1;
		}
		return a %7 + 1;
	}
	/**
	 * 随机产生1~5
	 * @return
	 */
	private static int rand5() {
		return new Random().nextInt(5)+1;
	}
}
