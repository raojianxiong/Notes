package algo.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，
 * 压出折痕后展开，此时折痕是凹下去的，即折痕突起的方向指向纸条的背面。
 * 如果从纸条的下边向上方连续对折两次，压出折痕后展开，此时有三条折痕，
 * 从上到下一次是下折痕、下折痕和上折痕。
 * 给定一个输入参数N，代表纸条都从下边向上方连续对折N次，
 * 请从上到下打印所有折痕的方向
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoFour {

	/**
	 * 第一次 下
	 * 第二次 下 下（第一次） 上
	 * 可以手动折叠，然后画个图 发现该问题就是满二叉树的遍历，左 根 右 中序遍历
	 * @param N
	 */
	public static List<String> folderPager(int N) {
	
		if(N <= 0) {
			return null;
		}
		List<String> data = new ArrayList<>();
		if(N == 1) {
			data.add("down");
			return data;
		}
		reInOrder(N-1, true, data);
		data.add("down");
		reInOrder(N-1,false, data);
		return data;
		
	}
	private static void reInOrder(int n,boolean flag,List<String> data) {
		if(n == 0) {
			return;
		}
		reInOrder(n-1, true, data);
		if(flag) {
			data.add("down");
		}else {
			data.add("up");
		}
		reInOrder(n-1,false, data);
	}
}
