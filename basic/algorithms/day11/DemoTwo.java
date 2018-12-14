package algo.day11;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 作为一个马场的主人，你要安排你的n匹马和另一个马场的n匹马比赛。
 * 你已经知道了对方马场的出站表，即参加每一场的马的强壮程度。
 * 当然你也知道你自己的所有马的强壮度。我们假定比赛的结果直接由马的强壮度决定，
 * 即更壮的马获胜（若相同则双方不算获胜）,请你设计一个策略，
 * 使你能获得尽量多的场次的胜利。
 * 给定对方每场比赛的马的强壮程度oppo及你的所有马的强壮程度horses(强壮程度为整数,且数字越大越强壮)，
 * 同时给定n,请返回最多能获胜的场次。测试样例，[1,2,3]
 * , [1,2,3] , 3 返回 2
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoTwo {
	public static void main(String[] args) {
		int data = winMost(new int[] {1,2,3}, new int[] {1,2,3},3);
		System.out.println("Win Most -> "+ data);
	}
	public static int winMost(int[] oppo,int[] horses,int n) {
		//首先对两个数组排序，找到我方数组第一个比对方0位置大的数 或者从尾到最前
		Arrays.sort(horses);
		Arrays.sort(oppo);
		int right = n-1,num = 0;
		for(int i = n-1;i>=0;i--) {
			if(horses[right] > oppo[i]) {
				right --;
				num ++;
			}
		}
//		int oppoIndex = 0;
//		int horsesIndex = 0;
//		while(true) {
//			if(oppoIndex == n || horsesIndex == n) {
//				break;
//			}
//			if(horses[horsesIndex ]>oppo[oppoIndex ] ) {
//				horsesIndex ++;
//				oppoIndex ++;
//				num ++;
//			}else {
//				horsesIndex ++;
//			}
//		}
		
		return num;
	}

}
