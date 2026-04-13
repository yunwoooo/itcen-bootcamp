package day4;

public class TwoArrayLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] two = new int[4][4];
		
		for (int i = 0; i < two.length; i++) {
			for (int j = 0; j < two[i].length; j++) {
				two[i][j] = 10 + 8*i + 2*j;
			}
		}
		
		System.out.printf("1행 1열의 데이터 : %d\n", two[0][0]);
		System.out.printf("3행 4열의 데이터 : %d\n", two[2][3]);
		System.out.printf("행의 갯수 : %d\n", two.length);
		System.out.printf("열의 갯수 : %d\n", two[0].length);
		System.out.print("3행의 데이터들 : ");
		for (int i = 0; i < two[2].length; i++)
			System.out.print(two[2][i] + " ");
		System.out.print("\n2열의 데이터들 : ");
		for (int i = 0; i < two.length; i++)
			System.out.print(two[i][1] + " ");
		System.out.print("\n왼쪽 대각선 데이터들 : ");
		for (int i = 0; i < two.length; i++)
			System.out.print(two[i][i] + " ");
		System.out.print("\n오른쪽 대각선 데이터들 : ");
		for (int i = 0; i < two.length; i++)
			System.out.print(two[i][two.length-1-i] + " ");
		
	}

}
