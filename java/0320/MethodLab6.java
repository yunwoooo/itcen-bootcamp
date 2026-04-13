package day5;

public class MethodLab6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary1 = powerArray(2);
		int[] ary2 = powerArray(3);
		int[] ary3 = powerArray(4);
		
		printArray(ary1);
		printArray(ary2);
		printArray(ary3);
	}

	static int[] powerArray(int num) {
		int[] ary = new int[10];
		for (int i = 0; i < ary.length; i++) {
			ary[i] = i + 1;
			ary[i] *= num;
		}
		return ary;
	}
	static void printArray(int[] ary) {
		for (int i = 0; i < ary.length; i++) {
			System.out.print(ary[i] + (i == ary.length - 1 ? "" : ","));
		}
		System.out.println();
	}
}
