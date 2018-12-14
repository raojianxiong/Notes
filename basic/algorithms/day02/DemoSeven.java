package algo.day02;

/**
 * 有一个整型数组A，请设计一个复杂度为O(N)的算法，算出排序后相邻两数的最大差值 [1,2,5,4,6],5 2
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoSeven {
	public static void sort(int[] data, int n) {
		int max = data[0], min = data[0];
		for (int i = 1; i < n; i++) {
			if (max < data[i]) {
				max = data[i];
			}
			if (min > data[i]) {
				min = data[i];
			}
		}
		if (max == min) {
			return;
		}
		int[] minA = new int[n + 1];//存放每个桶的最小值，最后一个桶存放最大值
		int[] maxA = new int[n + 1];//存放每个桶的最大值
		for(int i = 0;i<n+1;i++) {
			minA[i]= -1;
			maxA[i]= -1; 
			
		}
		double interval = (double) n / (max - min);
		for (int i = 0; i < n; i++) {
			int bucketId = (int)((data[i] - min) *interval);//data[i]*n/max;//
		
			if(minA[bucketId] == -1) {
				minA[bucketId]= data[i];
				maxA[bucketId] = data[i]; 
			
			}else {
				maxA[bucketId] = Math.max(data[i], maxA[bucketId]);
				minA[bucketId] = Math.min(data[i], minA[bucketId]);
				
			}
		}

		//找出第一个空桶前的前一个桶的最大值和最后一个空桶的后一个桶的最小值。
		int result = 0;
		int preV = maxA[0];
		for(int i = 1;i<n+1;i++) {
			if(minA[i]!=-1 ) {//最小值等于-1，说明此桶是空桶,当不为-1是是OK的
				System.out.print(result+"\t");
				result = Math.max(result, minA[i]- preV );
				preV = maxA[i];
			}
		}
		System.out.println("差值最大 -->> "+ result);
	}

	
	
}
