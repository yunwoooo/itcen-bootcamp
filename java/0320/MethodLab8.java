package day5;

public class MethodLab8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isRightTriangle(3, 4, 5));
		System.out.println(isRightTriangle(1, 2, 3));
	}
	static boolean isRightTriangle(int width, int height, int hypo) {
		if ((width * width) + (height * height) == (hypo * hypo))
			return true;
		else
			return false;
	}
}
