package algo.day09;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import jdk.dynalink.beans.StaticClass;

/**
 * 有一个机器按自然数序列的方式吐出球，1号球，2号球，3号球等等。
 * 你有一个袋子，袋子里最多只能装下K个球，
 * 并且除袋子以外，你没有更多的空间，一个球一旦扔掉，就再也不可拿回。
 * 设计一种选择方式，使得当机器吐出第N号球的时候，你袋子中的球数是K个，
 * 同时可以保证从1号球到N号球中的每一个，被选进袋子的概率都是K/N。
 * 举一个具体的例子，有一个只能装下10个球的袋子，当吐出100个球时，袋子里有10球，
 * 并且 1 ~ 100 号中的每一个球被选中的概率都是10/100。
 * 然后继续吐球，当吐出1000个球时，袋子里有 10 个球，并且1~1000号中的每一个球被选中的概率都是10/1000。
 * 继续吐球，当吐出 i 个球时，袋子里有 10 个球，并且 1 ~ i 号中的每一个球被选中的概率都是 10/i。
 * 也就是随着N的变化， 1 ~ N 号球被选中的概率动态变化成 K/N。
 * 请将吐出第N个球时袋子中的球的编号返回。
 * 思路:当N小于K时，N必定选进袋子里，否则以K/N的概率选进袋子
 * 
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoSeven {


	private  Random rand = new Random();
	private int[] result;
	private int k;
	public DemoSeven(int k) {
		result = new int[k];
		this.k = k;
	}
	/**
	 * 每次拿球调用
	 * @param n 取第n个球
	 * @return int[] 返回拿了第几号球
	 */
	public int[] machineSpit(int n) {
		if(n <= k) {
			result[n-1] = n;
		}else {
			int index = rand.nextInt(n);//随机数在k以下 
			if(index < k) {
				result[index] = n;
			}
		}
		return result;
	}
}
