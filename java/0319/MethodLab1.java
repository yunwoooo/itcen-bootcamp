package day4;

public class MethodLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("좋아하는 음식은 ");
		printMyFood();
		System.out.print(" 입니다.\n좋아하는 숫자는 " + getMyNumber() + " 입니다.");
	}
	static void printMyFood() {
		System.out.print("해산물");
		return;
	}
	
	static int getMyNumber() {
		return 7;
	}
}
