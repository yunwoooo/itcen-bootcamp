package day3;

public class ArrayLab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rsize = (int)(Math.random() * 6) + 5;
		int[] nums = new int[rsize];
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int)(Math.random() * 26) + 1;
			System.out.print(nums[i]);
			if ( i != nums.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		
		char[] alpha = new char[rsize];
		for (int j = 0; j < alpha.length; j++) {
			alpha[j] = (char)(nums[j] + 96);
			System.out.print(alpha[j]);
			if ( j != alpha.length - 1) {
				System.out.print(", ");
			}
		}
	}
}
