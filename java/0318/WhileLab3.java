package day3;

public class WhileLab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("[ 수행시작 ]");
		
		int count = 0;
		while (true) {
			int random = (int)(Math.random() * 31);
			char alpha = (char)(random + 64);
			
			
			if (random == 0 || random >= 27) {
				System.out.println("[ 수행 종료 ] - 출력횟수는 " + count + "번");
				break;
			}
			System.out.printf("%d-%c, %d, 0x%x\n", random, alpha, (int)alpha, (int)alpha);
			count++;
		}
	}

}
