package day4;

public class MethodLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("10은 %s 입니다.\n", isEven(10) ? "짝수" : "홀수" );
		System.out.printf("13은 %s 입니다.", isEven(13) ? "짝수" : "홀수" );
	}
	
	static boolean isEven(int num) {
		return num % 2 == 0;
	}
}
