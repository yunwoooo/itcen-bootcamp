package day3;

public class WhileLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int random = (int)(Math.random() * 6) +5;
		
		System.out.println("[ for 결과 ]");
		for (int i = 1; i <= random; i++) {
			System.out.println(i + " -> " + i*i);
		}
		
		int count = 0;
		System.out.println("\n[ while 결과 ]");
		while (true) {
			count++;
			if (count <= random) {
				System.out.println(count + " -> " + count*count);
			} else {
				break;
			}
		}
	}
}
