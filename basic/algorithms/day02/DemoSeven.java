package algo.day02;

/**
 * ��һ����������A�������һ�����Ӷ�ΪO(N)���㷨������������������������ֵ [1,2,5,4,6],5 2
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
		int[] minA = new int[n + 1];//���ÿ��Ͱ����Сֵ�����һ��Ͱ������ֵ
		int[] maxA = new int[n + 1];//���ÿ��Ͱ�����ֵ
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

		//�ҳ���һ����Ͱǰ��ǰһ��Ͱ�����ֵ�����һ����Ͱ�ĺ�һ��Ͱ����Сֵ��
		int result = 0;
		int preV = maxA[0];
		for(int i = 1;i<n+1;i++) {
			if(minA[i]!=-1 ) {//��Сֵ����-1��˵����Ͱ�ǿ�Ͱ,����Ϊ-1����OK��
				System.out.print(result+"\t");
				result = Math.max(result, minA[i]- preV );
				preV = maxA[i];
			}
		}
		System.out.println("��ֵ��� -->> "+ result);
	}

	
	
}
