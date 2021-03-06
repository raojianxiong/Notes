package algo.day11;

/**
 * 你要在一个n * m的格子图上涂色，你每次可以选择一个未涂色的格子涂上你开始选定的那种颜色
 * 。同时为了美观，我们要求你涂色的格子不能相邻，也就是说，不能有公共边，现在问你，在采取最优策略的情况下，你最多能涂多少个格子？给定格子图的长 n 和宽
 * m。请返回最多能涂的格子数目。测试样例：1，2 返回 ：1
 * 
 * - 智力题哦，左上角涂上选定的颜色，例如红色，那么可以理解为相邻的颜色填为白色，所以剩下的颜色基本就定了，如果是偶数的话，那就是 (n
 * *m)/2,奇数的话，那就是(n*m + 1)/2
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoOne {

	public static int getMost(int n,int m) {
		return (n*m + 1)/2;
	}
}
