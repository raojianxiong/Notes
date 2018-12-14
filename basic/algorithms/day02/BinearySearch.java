package algo.day02;

public class BinearySearch {

	/**
	 * 没有重复值的数组
	 * @param data
	 * @param value
	 */
	public static void sort(int[] data,int value) {
		int low = 0;
		int high = data.length -1;
		while(low <= high) {
			int mid = low + (high - low) >> 1;
			if(data[mid] > value) {
				high = mid -1;
			}else if(data[mid] < value) {
				low = mid + 1;
			}else {
				System.out.println("value == "+ value +"is in the "+mid +" index");
				return ;
			}
		}
		System.out.println("未找到");
	}
	/**
	 * 含有重复元素数组
	 * 查找第一个值等于给定值的元素
	 * @param data
	 * @param value
	 */
	public static void sort1(int[] data,int value) {
		int low = 0;
		int high = data.length -1;
		while(low <= high) {
			int mid = low + (high - low) >> 1;
			if(value < data[mid]) {
				high = mid -1;
			}else if(value > data[mid]) {
				low = mid + 1;
			}else {
				if(mid ==0 || data[mid-1] != value) {
					System.out.println("第一个值为"+value + "元素的index->"+mid);
					return;
				}else {
					high = mid -1;
				}
			}
		}
	}
	/**
	 * 含有重复元素数组
	 * 查找最后一个值等于给定值的元素
	 * @param data
	 * @param value
	 */
	public static void sort2(int[] data,int value) {
		int low = 0;
		int high = data.length -1;
		while(low <= high) {
			int mid = low + (high - low) >> 1;
			if(value < data[mid]) {
				high = mid -1;
			}else if(value > data[mid]) {
				low = mid + 1;
			}else {
				if(mid == data.length -1 || data[mid+1] != value) {
					System.out.println("最后一个值为"+value + "元素的index->"+mid);
					return;
				}else {
					low = mid +1;
				}
			}
		}
	}
	/**
	 * 含有重复元素数组
	 * 查找第一个值大于等于给定值的元素
	 * @param data
	 * @param value
	 */
	public static void sort3(int[] data,int value) {
		int low = 0;
		int high = data.length -1;
		while(low <= high) {
			int mid = low + (high - low) >> 1;
			if(value <= data[mid]) {
				if(mid == 0 || data[mid - 1] <value) {
					System.out.println("找到了 第一个大于等于"+value +"的元素，index -> "+mid);
					return;
				}
				high = mid -1;
			}else if(value > data[mid]) {
				low = mid + 1;
			}
		}
	}
	/**
	 * 含有重复元素数组
	 * 查找最后一个值小于等于给定值的元素,IP查询，最后一个小于等于该IP的区间，然后再去匹配
	 * @param data
	 * @param value
	 */
	public static void sort4(int[] data,int value) {
		int low = 0;
		int high = data.length -1;
		while(low <= high) {
			int mid = low + (high - low) >> 1;
			if(value < data[mid]) {
				
				high = mid -1;
			}else if(value >= data[mid]) {
				if(mid == data.length -1  || data[mid + 1] > value) {
					System.out.println("找到了 第一个小于等于"+value +"的元素，index -> "+mid);
					return;
				}
				low = mid + 1;
			}
		}
	}
	/**
	 * 循环数组 如 4 5 6 1 2 3
	 * @param data
	 * @param value
	 */
	public static void sort5(int[] data,int value) {
		int cycle = 0;
		for(int i= 0;i< data.length -1;i++) {
			if(data[i]  > data[i + 1]) {
				cycle = i + 1;//每个周期有多少个元素
			}
		}
		int low = 0,high = low + cycle -1;
		while(high <= data.length -1) {
			if(data[low] <= value && data[high] >= value) {
				//在这区间内，查找
				int left = low;
				int right = high;
				while(left <= right) {
					int mid = left +(right - left) >> 1;
					if(data[mid] == value) {
						System.out.println("找到了 -> "+mid);
						return;
					}else if(data[mid] > value) {
						right = mid -1;
					}else {
						left = mid + 1;
					}
				}
			}
		}
		low = low + cycle;
		high = high + cycle;
	}
}
