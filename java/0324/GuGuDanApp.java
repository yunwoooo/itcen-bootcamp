package day7;

public class GuGuDanApp {
	public static void main(String[] args) {
		int dan = (int)(Math.random() * 20) + 1;
		int number = (int)(Math.random() * 20) + 1;
		
		if ( 1 <= dan && dan <= 9 && 1 <= number && number <= 9) {
			GuGuDanExpr gugudan1 = new GuGuDanExpr(dan, number);
			System.out.print(dan + " * " + number + " = " );
			gugudan1.printPart();
		} else if ( 1 <= dan && dan <= 9 && 10 <= number) {
			GuGuDanExpr gugudan2 = new GuGuDanExpr(dan, 0);
			System.out.print(dan + "단 : ");
			gugudan2.printPart();
		} else if (10 <= dan) {
			GuGuDanExpr.printAll();
		}
	}
}
