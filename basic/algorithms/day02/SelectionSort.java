package algo.day02;
/**
 * 最好情况O(n2)
 * 最坏情况O(n2)
 * 不稳定排序，每次选择后面元素的最小值进行交换
 * @author Jianxiong Rao
 *
 */
public class SelectionSort {
	public static int[] sort(int[] data) {
		if(data == null) return null;
		
		for(int i = 0;i<data.length;i++) {
			int mim = i;
			for(int j= mim +1;j<data.length;j++) {
				if(data[mim] >data[j] ) {
					mim = j;
				}
			}
			if(mim != i) {
				int temp = data[i];
				data[i]= data[mim];
				data[mim]= temp; 
			}
		}
		return data;
	}
}
