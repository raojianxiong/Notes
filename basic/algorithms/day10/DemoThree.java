package algo.day10;

/**
 * 给定一个矩阵m,从左上角开始每次只能向右或者向下走，
 * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，
 * 返回所有的路径种最小的路径和。如果给定的m如大家看到的样子，
 * 路径1，3，1，0，6，1，0是所有路径和最小的，所以返回12
 * 给定一个矩阵map以及它的行数n和列数m,行列数均小于等于100
 * 
 * @author Jianxiong Rao
 *
 */
public class DemoThree {

	public static int minmiumPath(int[][] map,int n,int m) {
		//新建个数组，n * m
		//dp[i][j]  的值表示从左上角，也就是(0,0) 位置，走到(i,j) 位置的最小路径和
		int[][] data = new int[n][m];
		data[0][0] = map[0][0];
		//第一列
		for(int i = 1;i<n;i++) {
			data[i][0] = data[i-1][0]+map[i][0]; 
		}
		//第一行
		for(int i = 1;i<m;i++) {
			data[0][i]= data[0][i-1] + map[0][i]; 
		}
		
		for(int i = 1;i< n;i++) {
			for(int j =1;j<m;j++) {
				//最短路径不是向下走就是向左走
				data[i][j]= map[i][j] + Math.min(data[i-1][j], data[i][j-1]);  
			}
		}
		return data[n-1][m-1];
		
	}
}
