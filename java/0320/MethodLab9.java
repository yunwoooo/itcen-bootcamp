package day5;

public class MethodLab9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[] = new int[] { 1,2,3,4,5 };
		MethodLab6.printArray(a1);
		powerArray(a1, 3);
		MethodLab6.printArray(a1);

		int a2[] = new int[] { 10,20,30,40,50,60 };
		MethodLab6.printArray(a2);
		powerArray(a2, 10);
		MethodLab6.printArray(a2);
	}

	static void powerArray(int[] ary, int num) {
		if ( 2 <= num && num <= 5) {
			for (int i = 0; i < ary.length; i++) {
				ary[i] *= num;
			}
		} else {
			return;
		}
	}
}
