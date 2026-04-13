package day4;

public class TwoArrayLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] chr = {
				{'B', 'C', 'A', 'A'},
				{'C', 'C', 'B', 'B'},
				{'D', 'A', 'A', 'D'},
		};
		int[] count = new int[4];
		int alpha = 0;
		for (int i = 0; i < chr.length; i++) {
			for (int j = 0; j < chr[i].length; j++) {
				alpha = (int)(chr[i][j] - 65);
				count[alpha]++;
			}
		}
		
		for (int i = 0; i < count.length; i++) {
			System.out.printf("%s는 %d개 입니다.\n", (char)(i+65) ,count[i]);
		}
	}
}
