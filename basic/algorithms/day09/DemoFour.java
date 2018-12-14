package algo.day09;

import java.util.Random;

/**
 * 给定一个以p概率产生0，以1-p概率产生1的随机函数f(),p是固定值，
 * 但你并不知道是多少，
 * 除此之外也不能使用任何额外的随机机制，请用f()实现等概率随机产生0和1的随机函数
 * 产生01和10的概率是相等的。
 * @author Jianxiong Rao
 *
 */
public class DemoFour {

	public static int random() {
		int a ,b;
		while(true) {
			
			a = f();
			b = f();
			if(a != b) {
				return a> b?0:1;
			}
		}
	}
	private static int f() {
		return new Random().nextInt(1);
	}
}
