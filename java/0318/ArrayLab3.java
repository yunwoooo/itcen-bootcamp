package day3;

public class ArrayLab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] elem = new char[] { 'J', 'a', 'v', 'a' };
		for (int i = 0; i < elem.length; i++) {
			if ( 'A' <= elem[i] && elem[i] <= 'Z') {
				elem[i] = (char)(elem[i] + 32);
			} else {
				elem[i] = (char)(elem[i] - 32);
			}
			
			System.out.println(elem[i]);
		}
	}

}
