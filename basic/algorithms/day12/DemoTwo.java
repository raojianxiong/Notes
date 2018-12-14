package algo.day12;


public class DemoTwo {

	/**
	 * log(m +n) 
	 *   查找两个有序数组的中位数
	 *     二分法,比较中位数大小，不断缩小判断位置
	 * @param A
	 * @param startA 数组开始位置
	 * @param endA 结束位置
	 * @param B
	 * @param startB
	 * @param endB
	 * @return
	 */
	public static int findMedianLogn(int[] A,int startA,int endA,int B[],int startB,int endB) {
		if(A ==null || B==null || endA < 0 || endB <0) {
			return -1;
		}
		int m1 =startA + (endA -startA )/2, m2 =startB +  (endB -startB )/2;
		int n1 = endA - startA + 1,n2 = endB - startB +1;
		if(n1 ==1) {
			//递归结束条件
			if(n2 ==1) {
				return A[startA] < B[startB] ?A[startA]:B[startB];
			}
			if(n2 %2 == 0) {
				if(A[startA] >= B[m2 +1]) {
					return B[m2 +1];
				}else if(A[startA] <= B[m2]) {
					return B[m2];
				}else {
					return A[startA];
				}
			}else {
				if(A[startA] >=B[m2]) {
					return B[m2];
				}else if(A[startA] <= B[m2-1]) {
					return B[m2 -1];
				}else {
					return A[startA];
				}
			}
		}else if(n2 == 1) {
			if(n1 %2 == 0) {
				if(B[startB] >= A[m1 +1]) {
					return A[m1+1];
				}else if(B[startB] <= A[m1]) {
					return A[m1];
				}else {
					return B[startB];
				}
			}else {
				if(B[startB] >= A[m1]) {
					return A[m1];
				}else if(B[startB] <= A[m1-1]) {
					return A[m1 -1];
				}else {
					return B[startB];
				}
			}
		}else {
			int cutLen = n1/2 > n2 /2 ? n2/2:n1/2;//选最小的
			if(A[m1] == B[m2]) {
				return A[m1];
			}else if(A[m1] > B[m2]) {
				return findMedianLogn(A, startA,endA-cutLen, B, startB + cutLen,endB);
			}else {
				return findMedianLogn(A, startA + cutLen,endA, B, startB,endB-cutLen);
			}
		}
	}
	/**
	 * 查找两个有序数组中第K小的数
	 * @param A
	 * @param n1
	 * @param B
	 * @param n2
	 * @return
	 */
	public static int findKthSmallest(int[] A,int n1,int[] B,int n2,int k) {
		//边界条件处理
		if(n1 == 0 && n2 ==0) return -1;
		int startA = 0,startB = 0,endA = A.length -1,endB = B.length -1;
		int result = findKth(A, startA, endA, B, startB, endB,k);
		return result;
	}
	private static int findKth(int[] A,int startA,int endA,int[] B,int startB,int endB,int k) {
		int n1 = endA - startA + 1;
		int n2 = endB - startB + 1;
		if(n1 == 0) return B[startB + k-1];
		if(n2 == 0) return A[startA  + k-1];
		
		if(k == 1) return A[startA] > B[startB] ? B[startB] : A[startA];
		
		//下面即将划分区间
		int x1 = (int)(n1*1.0 /(n1  + n2) *(k-1));
		int x2 = k - 2 - x1;
		int idx1 =startA +  x1;
		int idx2 = startB +  x2;

		if(A[idx1] == B[idx2]) {
			return A[idx1];
		}else if( A[idx1] < B[idx2]) {
			//A[idx1 + 1 .....n] B[0....idx2]
			return findKth(A, idx1 + 1,endA, B, startB,idx2, k-x1-1);//k - (idx1+1)
		}else {
			//A[0...idx1] B[idx2 ..n]
			return findKth(A,startA,idx1,B,idx2+1,endB,k - x2 -1);
		}
	}
}
