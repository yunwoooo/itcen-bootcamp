package day3;

public class ArrayLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary = new int[10];
		
		for (int i = 0; i < ary.length; i++) {
			System.out.print(ary[i] + " ");
		}
		System.out.println();
		ary = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		
		int first = ary[0];
		int last = ary[ary.length - 1];
		System.out.println("첫 번째 : " + first);
		System.out.println("마지막 : " + last);
		System.out.println("합 : " + (first + last));
		
		for (int elem : ary) {
			System.out.print(elem + " ");
		}
		System.out.println();
		
		for (int j = ary.length - 1; j >= 0; j--) {
			System.out.print(ary[j] + " ");
		}
		System.out.println();
		
		for (int k = 1; k < ary.length; k += 2) {
			System.out.print(ary[k] + " ");
		}
	}
}
