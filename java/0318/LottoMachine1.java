package day3;

public class LottoMachine1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] lotto = new int[6];
		int count = 0;
		
		while (true) {
			int num = (int)(Math.random() * 45) + 1;
			boolean flag = true;
			
			for (int i = 0; i < count; i++) {
				if (lotto[i] == num) {
			        flag = false;
			        break;
			    }
			}
			
			if (flag == true) {
				lotto[count] = num;
				count++;
			}
					
			if (count == 6) {
				break;
			}
		}
		
		System.out.print("오늘 로또 번호 - ");
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i]);
			if (i != lotto.length - 1) {
				System.out.print(", ");
			}
		}
	}
}