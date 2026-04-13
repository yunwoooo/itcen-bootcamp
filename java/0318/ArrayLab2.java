package day3;

public class ArrayLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[10];
		int sum = 0;
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int)(Math.random() * 17) + 4;
		}
		
		System.out.print("모든 원소의 값 : ");
		
		for (int j = 0; j < nums.length; j++) {
			sum += nums[j];
			System.out.print(nums[j]);
			if (j != nums.length - 1) {
				System.out.print(",");
			}
		}
		
		System.out.println("\n모든 원소의 합 : " + sum);
	}

}
