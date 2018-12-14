package algo.day02;

/**
 * 有一个只由 0
 * 、1、2三种元素构成的整数数组，
 * 请使用交换、原地排序而不是使用计数进行排序。给定一个只含0，1，2的整数数组A及它的大小，
 * 请返回排序后的数组。保证数组大小小于等于500。
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoFour {

	public static void sort(int[] data,int n) {
		int lt = 0,gt = n;// [left...lt] < value ,[lt+1....gt] = value ,[gt+1... n-1] > value
		int value = 1;
		int i = 0;
		while(i < gt) {
			if(data[i] < value) {
				int temp = data[i];
				data[i]= data[lt];
				data[lt] = temp;
				i++;
				lt ++;
			}else if(data[i]> value ) {
				int temp = data[i];
				data[i]= data[gt -1];
				data[gt-1] = temp;
				gt --;
			}else {
				i++;
			}
		}
		
		for(int result:data) {
			System.out.print(result + "\t");
		}
	}
}
