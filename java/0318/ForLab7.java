package day3;

public class ForLab7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final char LAB = '&';
		int random = (int)(Math.random() * 6) + 5;
		System.out.println("추출된 숫자 : " + random);
		
		for (int i = 1; i <= random; i++) {
			for (int count=1; count <= i; count++) {
				System.out.print(LAB);
			}
			System.out.println();
		}

	}

}
