package algo.day02;
/**
 * 桶排序
 * @author Jianxiong Rao
 *
 */
public class BarrelSort {

	/**
	 * 如果已知这些数的范围 例如为0 到 100 分
	 * O(2*（m+n)) -> O(M)
	 * @param data
	 */
	public static void sort(int... data) {
		int[] a = new int[101];
		//初始值都为0，代表出现过0次该分
		for(int i =0;i<data.length;i++) {// n次
			a[data[i]] ++;
		}
		for(int i=0;i<a.length;i++) {// m 次
			if(a[i]!= 0 ) {
				for(int j = 0;j<a[i];j++) { // m- 不等于0 次
					System.out.print(i+"\t"); // n次
				}
//				System.out.println();
			}
			
		}
		
	}
	/**
	 * 计数排序 基于桶排序思想，由于数过多，可以使用数出现的频率作为桶编号
	 * @param data
	 */
	public static void sortCount(int min,int max,int... data) {
		int length = max - min + 1;
		int[] a = new int[length];
		
		for(int i = 0;i<data.length;i++) {//最小值对应数组下标 0
			a[data[i]- min] ++;//出现了多少次
		}
		for(int i =0;i<a.length;i++) {
			if(a[i]!= 0 ) {
				for(int j = 0;j<a[i];j++) {
				System.out.print((i+min)+"\t");	
				}
			}
		}
	}
	/**
	 * 基数排序
	 * 空间O(N)
	 * 时间O（N*digist)
	 * @param max
	 * @param data
	 */
	public static void sortBase(int max,int... data) {
		int base = 10;
		int length= 1;
		while(max>base) {
			length ++;
			base *= 10;
		}
		
		int[] temp = new int[data.length];//0.....9
		int dividend = 1;
		while(length>0) {
			int[] count = new int[10];
			//统计某一位出现相同数字的个数
			for(int i = 0;i<data.length;i++) {
				int index = data[i]/dividend %10;
				count[index]++;
			}
			
			//统计个位相同的数在数组中出现的位置
			for(int i = 1;i<10;i++) { //0 出现0次 1出现2次 2出现3次 那么2的下标为 1 2 3
				count[i]+= count[i-1]; //i出现的位置为 i +(i-1)
			}
			for(int i =data.length-1;i>=0;i--) {
				int index = data[i]/dividend %10; 

				temp[--count[index]] = data[i];//先使用再增加，记录的是个数某个数字出现的起始位置
			}
			dividend *= 10;
			length --;
		}
		
		for(int n:temp) {
			System.out.print(n+"\t");
		}
	}
	
	
	
}
