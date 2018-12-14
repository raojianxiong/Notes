

package algo.day03;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，
 * 窗口每次向右边滑一个位置，返回一个长度为n-w+1的数组res,res[i]则表示每一种窗口状态下的最大值。
 * 以数组为[4,3,5,4,3,3,6,7],w = 3为例， 最后res为[5,5,5,4,6,7] 每移动一次比较w个数，复杂度为O（N*w)
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoFive {

	public int[] slid(int[] data, int n, int w) {
		if (data == null || n < w) {
			return null;
		}
		int[] res = new int[n - w + 1];
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (deque.isEmpty()) {
				deque.offerLast(i);
			} else {
				if (data[deque.getLast()] > data[i]) {
					// 队尾元素大于data[i]
					deque.offerLast(i);
				} else {
					deque.removeLast();
					while (!deque.isEmpty() && data[deque.getLast()] <= data[i]) {
						deque.removeLast();
					}
					deque.offerLast(i);
				}
			}
			while(i - deque.getFirst() >= w) {
				//窗口滑动，_ _ _ | _ _ _ | _ _ _ | _ _ _  位移大 3n 倍时，需要将前一个窗口的下标清楚
				deque.removeFirst();
			}
			//因为 i = w-1 时开始入数组
			if(i+1 - w >= 0) {
				res[i+1-w] = data[deque.getFirst()];
			}
		}
		return res;
	}
}
