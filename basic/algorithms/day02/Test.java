package algo.day02;

public class Test {
	public static void main(String[] args) {
			int[] a = {4,5,6,3,2,1};
			for(int data:BubbleSort.sort(a)) {
				System.out.print(data+"\t");
			}
			System.out.println();
			int[] b = {4,5,6,3,2,1};
			for(int data:InsertionSort.sort(b)) {
				System.out.print(data+"\t");
			}
			System.out.println();
			int[] c = {4,5,6,3,2,1};
			System.out.println("Show Time");
			for(int data:QuickSort.sort(c)) {
				System.out.print(data+"\t");
			}
		System.out.println("======");
		HeapSort heapSort = new HeapSort(7);
		heapSort.insert(4);
		heapSort.insert(5);
		heapSort.insert(6);
		heapSort.insert(3);
		heapSort.insert(2);
		heapSort.insert(1);
		
		for(int i = 5;i >=0;i--) {
			System.out.print(heapSort.extractMax()+"\t");
		}
		System.out.println();
		
		int[] d = new int[] {5,3,5,2,8};
		BarrelSort.sortBase(8,d);
		System.out.println();
		
		DemoOne.sortElement(new int[] {2,5,4,6,8,9,11,9,8,12,11,16},12, 4);
		System.out.println();
		boolean flag = DemoTwo.sort(new int[] {2,3,1,6,4,6,8}, 7);
		System.out.println("有无重复 -->> "+ flag);
		DemoThree.sort();
		System.out.println();
		DemoFour.sort(new int[] {1,2,0,0,1,1,2,0},8);
		
		System.out.println();
		boolean isHave = DemoFive.sort(new int[][] {{1,2,3},{4,5,6},{7,8,9}},3, 3, 1);
		System.out.println("矩阵中含有 -> "+ 3 +"-> "+isHave);
		
		DemoSix.sort(new int[] { 1,5,4,3,2,6,7}, 7);
		
		DemoSeven.sort(new int[] {1,2,5,4,6}, 5);
	

	}
}
