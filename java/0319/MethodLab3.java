package day4;

public class MethodLab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int random1, random2;
		for (int i = 0; i < 6; i++) {
			random1 = (int)(Math.random() * 30) + 1;
			random2 = (int)(Math.random() * 30) + 1;
			System.out.printf("%d 와 %d 의 차는 %d 입니다.\n", random1, random2, getMargin(random1, random2));
		}
	}
	static int getMargin(int num1, int num2) {
		if (num1 > num2) {
			return num1 - num2;
		} else {
			return num2 - num1;
		}
	}
}
