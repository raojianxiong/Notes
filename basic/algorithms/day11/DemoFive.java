package algo.day11;

import java.util.HashMap;
import java.util.Map;

/**
 * 现在有一个整数数组，其元素值均为 1-n 范围内的某个整数，
 * 现在你和你的朋友在玩一个游戏，游戏的目的是把数组清空，你们轮流操作，你是先手，
 * 每次操作你可以删除数组中值为某个数的元素任意多个(当然数组中值为这个数的元素个数应大于等于你删除的个数，
 * 且至少要删除一个数)。最先把数组清空的人获得胜利。假设你们都采取最优策略，请你计算你能否获得胜利。
 * 给定一个整数数组A和元素个数n。
 * 请返回一个整数，1代表你能获胜，0代表你不能获胜。测试样例：[1,1,1] 返回：1
 * 核心思想就是盘算所有数字的统计结果是否有偶数对相同的，如统计结果1有3个，2有3个，没有其他数字，那肯定是后手赢，如果1有2个，2有3个肯定是先手赢，或者是1有3个，2有3个，3有3个还是后手赢。
 * @author Jianxiong Rao
 *
 */
public class DemoFive {
	public static int win(int[] A,int n) {
		Map<String, Integer> map = new HashMap<>();
		
		//1. 先记录数组中每个元素出现的次数
		for(int i = 0;i<n;i++) {
			if(map.containsKey(String.valueOf(A[i]))) {
				map.put(String.valueOf(A[i]), 1);
			}else {
				map.put(String.valueOf(A[i]), map.get(String.valueOf(A[i]))+1);
			}
		}
		
		//2.采用最优策略，所以如果map的大小为偶数，而你又是先手，那么你就输了
		if(map.size() %2 ==0) {
			return 0;
		}else {
			return 1;
		}
		
	}

}
