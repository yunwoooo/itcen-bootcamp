package day3;

public class ControlLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count = 0;
		while (true) {
			int random = (int)(Math.random() * 11) + 10;
			
			System.out.println("난수 = " + random);
			if (random % 3 == 0 || random % 5 == 0) {
				int sum = 0;
				for (int i = 1; i <= random; i++) {
					sum += i;
				}
				System.out.println("1부터 " + random + "까지의 합은 " + sum);
				count++;
			} else if (random == 11 || random == 17 || random == 19) {
				break;
			} else {
				System.out.println("재수행");
				continue;
			}
			
		}
		System.out.println(count + "회 반복함");
	}

}
