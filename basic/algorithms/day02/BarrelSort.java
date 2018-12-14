package algo.day02;
/**
 * Ͱ����
 * @author Jianxiong Rao
 *
 */
public class BarrelSort {

	/**
	 * �����֪��Щ���ķ�Χ ����Ϊ0 �� 100 ��
	 * O(2*��m+n)) -> O(M)
	 * @param data
	 */
	public static void sort(int... data) {
		int[] a = new int[101];
		//��ʼֵ��Ϊ0��������ֹ�0�θ÷�
		for(int i =0;i<data.length;i++) {// n��
			a[data[i]] ++;
		}
		for(int i=0;i<a.length;i++) {// m ��
			if(a[i]!= 0 ) {
				for(int j = 0;j<a[i];j++) { // m- ������0 ��
					System.out.print(i+"\t"); // n��
				}
//				System.out.println();
			}
			
		}
		
	}
	/**
	 * �������� ����Ͱ����˼�룬���������࣬����ʹ�������ֵ�Ƶ����ΪͰ���
	 * @param data
	 */
	public static void sortCount(int min,int max,int... data) {
		int length = max - min + 1;
		int[] a = new int[length];
		
		for(int i = 0;i<data.length;i++) {//��Сֵ��Ӧ�����±� 0
			a[data[i]- min] ++;//�����˶��ٴ�
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
	 * ��������
	 * �ռ�O(N)
	 * ʱ��O��N*digist)
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
			//ͳ��ĳһλ������ͬ���ֵĸ���
			for(int i = 0;i<data.length;i++) {
				int index = data[i]/dividend %10;
				count[index]++;
			}
			
			//ͳ�Ƹ�λ��ͬ�����������г��ֵ�λ��
			for(int i = 1;i<10;i++) { //0 ����0�� 1����2�� 2����3�� ��ô2���±�Ϊ 1 2 3
				count[i]+= count[i-1]; //i���ֵ�λ��Ϊ i +(i-1)
			}
			for(int i =data.length-1;i>=0;i--) {
				int index = data[i]/dividend %10; 

				temp[--count[index]] = data[i];//��ʹ�������ӣ���¼���Ǹ���ĳ�����ֳ��ֵ���ʼλ��
			}
			dividend *= 10;
			length --;
		}
		
		for(int n:temp) {
			System.out.print(n+"\t");
		}
	}
	
	
	
}
