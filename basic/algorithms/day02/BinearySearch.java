package algo.day02;

public class BinearySearch {

	/**
	 * û���ظ�ֵ������
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
		System.out.println("δ�ҵ�");
	}
	/**
	 * �����ظ�Ԫ������
	 * ���ҵ�һ��ֵ���ڸ���ֵ��Ԫ��
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
					System.out.println("��һ��ֵΪ"+value + "Ԫ�ص�index->"+mid);
					return;
				}else {
					high = mid -1;
				}
			}
		}
	}
	/**
	 * �����ظ�Ԫ������
	 * �������һ��ֵ���ڸ���ֵ��Ԫ��
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
					System.out.println("���һ��ֵΪ"+value + "Ԫ�ص�index->"+mid);
					return;
				}else {
					low = mid +1;
				}
			}
		}
	}
	/**
	 * �����ظ�Ԫ������
	 * ���ҵ�һ��ֵ���ڵ��ڸ���ֵ��Ԫ��
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
					System.out.println("�ҵ��� ��һ�����ڵ���"+value +"��Ԫ�أ�index -> "+mid);
					return;
				}
				high = mid -1;
			}else if(value > data[mid]) {
				low = mid + 1;
			}
		}
	}
	/**
	 * �����ظ�Ԫ������
	 * �������һ��ֵС�ڵ��ڸ���ֵ��Ԫ��,IP��ѯ�����һ��С�ڵ��ڸ�IP�����䣬Ȼ����ȥƥ��
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
					System.out.println("�ҵ��� ��һ��С�ڵ���"+value +"��Ԫ�أ�index -> "+mid);
					return;
				}
				low = mid + 1;
			}
		}
	}
	/**
	 * ѭ������ �� 4 5 6 1 2 3
	 * @param data
	 * @param value
	 */
	public static void sort5(int[] data,int value) {
		int cycle = 0;
		for(int i= 0;i< data.length -1;i++) {
			if(data[i]  > data[i + 1]) {
				cycle = i + 1;//ÿ�������ж��ٸ�Ԫ��
			}
		}
		int low = 0,high = low + cycle -1;
		while(high <= data.length -1) {
			if(data[low] <= value && data[high] >= value) {
				//���������ڣ�����
				int left = low;
				int right = high;
				while(left <= right) {
					int mid = left +(right - left) >> 1;
					if(data[mid] == value) {
						System.out.println("�ҵ��� -> "+mid);
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
