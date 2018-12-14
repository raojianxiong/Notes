

package algo.day03;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ��һ����������arr��һ����СΪw�Ĵ��ڴ����������߻������ұߣ�
 * ����ÿ�����ұ߻�һ��λ�ã�����һ������Ϊn-w+1������res,res[i]���ʾÿһ�ִ���״̬�µ����ֵ��
 * ������Ϊ[4,3,5,4,3,3,6,7],w = 3Ϊ���� ���resΪ[5,5,5,4,6,7] ÿ�ƶ�һ�αȽ�w���������Ӷ�ΪO��N*w)
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
					// ��βԪ�ش���data[i]
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
				//���ڻ�����_ _ _ | _ _ _ | _ _ _ | _ _ _  λ�ƴ� 3n ��ʱ����Ҫ��ǰһ�����ڵ��±����
				deque.removeFirst();
			}
			//��Ϊ i = w-1 ʱ��ʼ������
			if(i+1 - w >= 0) {
				res[i+1-w] = data[deque.getFirst()];
			}
		}
		return res;
	}
}
