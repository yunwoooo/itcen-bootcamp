package day4;

public class TwoArrayLab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {
				{10, 20, 30, 40, 50},
				{5, 10, 15},
				{11, 22, 33, 44},
				{9, 8, 7, 6, 5, 4, 3, 2, 1},
		};
		
		int[] sum = new int[4];
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				sum[i] += nums[i][j];
			}
		}
		
		for (int i = 0; i < sum.length; i++) {
			 System.out.printf("%d행의 합은 %d입니다.\n", (i+1), sum[i]);
		}
	}

}
