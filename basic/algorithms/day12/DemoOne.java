package algo.day12;

public class DemoOne {

	/**
	 * 顺时针打印矩阵
	 * @param data
	 * @return
	 */
	public static int[] printMatrix(int[][] data) {
		if(data == null ) return null;
		int row = data.length;
		int col = data[0].length;
		
		int[] result = new int[row * col];
		
		int top = 0;
		int bottom = row - 1;
		int left = 0;
		int right = col - 1;
		
		int index = 0;
		while(top <= bottom && left <= right) {
			for(int m = left;m<=right;m++) {
				result[index] = data[top][m];
				index ++;
			}
			for(int m = top+1;m<=bottom;m++) {
				result[index] = data[m][right];
				index ++;
			}
			
			//top == bottom 说明只有一行
			if(top != bottom) {
				for(int m = right-1;m >=left;m--) {
					result[index] = data[bottom][m];
					index ++;
				}
			}
			// left == right 说明只有一列
			if(left != right) {
				for(int m = bottom -1;m>top;m--) {
					result[index] = data[m][left];
					index ++;
				}
			}
			
			left ++;
			right --;
			top ++;
			bottom --;
		}
		
		return result;
		
	}
}
