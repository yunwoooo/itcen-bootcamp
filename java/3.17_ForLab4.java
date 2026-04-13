package day2;

public class ForLab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int random1 = (int)(Math.random() * 10) + 1;
		int random2 = (int)(Math.random() * 11) + 30;
		int sum = 0;
		
		for (int i = random1; i <= random2; i += 1) {
			if (i % 2 == 0)
				sum += i;
		}

		System.out.println(random1 + " 부터 " + random2 + " 까지의 짝수의 합 : " + sum);
	}

}
