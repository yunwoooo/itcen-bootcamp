package day4;

public class TwoArrayLab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] time = {
				{5, 2, 1, 0, 2, 3, 6},
				{4, 3, 2, 1, 1, 0, 5},
				{3, 1, 2, 1, 3, 1, 3},
				{4, 3, 1, 0, 4, 2, 7},
		};
		int[] day = new int[7];
		int[] sum = new int[4];
		
		char[] today = {'일', '월', '화', '수', '목', '금', '토'};
		int[] week = {1, 2, 3, 4};
		
		for (int i = 0; i < time.length; i++) {
			for (int j = 0; j < time[i].length; j++) {
				day[j] += time[i][j];
				sum[i] += time[i][j];
			}
		}
		
		for (int i = 0; i < day.length; i++) {
			System.out.printf("%s요일 : %d시간\n", today[i], day[i]);
		}
		System.out.println();
		for (int i = 0; i < sum.length; i++) {
			System.out.printf("%s주자 : %d시간\n", week[i], sum[i]);
		}
		
	}

}
