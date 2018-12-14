package algo.day10;

/**
 * ����һ������m,�����Ͻǿ�ʼÿ��ֻ�����һ��������ߣ�
 * ��󵽴����½ǵ�λ�ã�·�������е������ۼ���������·���ͣ�
 * �������е�·������С��·���͡����������m���ҿ��������ӣ�
 * ·��1��3��1��0��6��1��0������·������С�ģ����Է���12
 * ����һ������map�Լ���������n������m,��������С�ڵ���100
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoThree {

	public static int minmiumPath(int[][] map,int n,int m) {
		//�½������飬n * m
		//dp[i][j]  ��ֵ��ʾ�����Ͻǣ�Ҳ����(0,0) λ�ã��ߵ�(i,j) λ�õ���С·����
		int[][] data = new int[n][m];
		data[0][0] = map[0][0];
		//��һ��
		for(int i = 1;i<n;i++) {
			data[i][0] = data[i-1][0]+map[i][0]; 
		}
		//��һ��
		for(int i = 1;i<m;i++) {
			data[0][i]= data[0][i-1] + map[0][i]; 
		}
		
		for(int i = 1;i< n;i++) {
			for(int j =1;j<m;j++) {
				//���·�����������߾���������
				data[i][j]= map[i][j] + Math.min(data[i-1][j], data[i][j-1]);  
			}
		}
		return data[n-1][m-1];
		
	}
}
