package algo.day10;

/**
 * ���������ַ���str1��str2���ٸ�����������ic��dc����rc,�ֱ������롢ɾ�������滻һ���ַ��Ĵ��ۡ�
 * ���ؽ�str1�༭��str2����С���ۡ�
 * ���磬str1="abc",str2="adc",ic=5,dc=3,rc=2��
 * �ӡ�abc"�༭��"adc"����"b"�滻��"d"�Ǵ�����С�ģ����Է���2��
 * �ٱ��磬str1="abc",str2="adc",ic=5,dc=3,rc=100��
 * ��"abc"�༭��"adc",��ɾ��b��Ȼ���ٲ���"d"�Ǵ�����С�ģ����Է���8��
 * ���������ַ���A��B���Լ����ǵĳ��Ⱥ����ֲ����Ĵ��ۣ��뷵�ؽ�A���B����С���ۡ�
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoSeven {

	public static int findMinCost(String A,int n,String B,int m,int ic,int dc,int rc) {
		int[][] dp = new int[n+1][m+1];
		//�����һ�У���һ�ж����ó� i * ic ���� i * dc ,���ǵ�0 ��0���ǿ��ַ���
		for(int i = 0 ;i< n+1;i++) {
			dp[i][0] = i * dc;
		}
		for(int i = 0;i<m + 1;i++) {
			dp[0][i]= i* ic; 
		}
		//ע�� �����ж�ӦA B �ַ����Ǵ�λ��1��ʼ�ģ�0λ���ǿ��ַ���������dp[i][j] ��ָ�ַ���0��i-1λ�ã�0��j-1λ��
		for(int i = 1;i< n+1;i++) {
			for(int j = 1;j<m+1;j++) {
				int temp1=0,temp2=0,result;
				//��������ͼ��������������ˣ�����a�仯��b�Ŀ�����
				temp1 = Math.min(dp[i][j-1]+ic, dp[i-1][j]+dc);
				if(A.charAt(i-1) == B.charAt(i-1)) {
					temp2 = dp[i-1][j-1];
				}else {
					temp2 = dp[i-1][j-1] + rc;
				}
				result = Math.min(temp1, temp2);
				dp[i][j]= result; 
			}
		}
		return dp[n][m];
	}
}
