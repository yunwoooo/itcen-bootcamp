package day7;

class GuGuDanExpr extends Multiplication {
	GuGuDanExpr() {}
	GuGuDanExpr(int dan) {
		super(dan);
	}
	GuGuDanExpr(int dan, int number) {
		super(dan, number);
	}
	
	public static void printAll() {
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(i + " * " + j + " = " + i * j + "\t");
			}
			System.out.println();
		}
	}
}
