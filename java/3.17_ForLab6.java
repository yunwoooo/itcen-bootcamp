package day2;

public class ForLab6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int random1 = (int)(Math.random() * 8) + 3;
		int random2 = (int)(Math.random() * 3) + 1;
		
		for (; random1 > 0; random1--) {
			if (random2 == 1)
				System.out.print("*");
			else if (random2 == 2)
				System.out.print("$");
			else
				System.out.print("#");
		}
		
	}

}
