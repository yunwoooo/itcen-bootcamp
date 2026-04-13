package day4;

public class MethodLab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			if ( i < 4) {
				System.out.print(getRandom(10) + ", ");
			} else {
				System.out.print(getRandom(10));
			}
		}
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			if ( i < 4) {
				System.out.print(getRandom(10, 20) + ", ");
			} else {
				System.out.print(getRandom(10, 20));
			}
		}
	}
	static int getRandom(int n) {
		return (int)(Math.random() * n) + 1;
	}
	static int getRandom(int n1, int n2) {
		return (int)(Math.random() * (n2 - n1 + 1)) + n1;
	}
}
