package day6;

class SalaryExpr {
	int bonus;
	
	SalaryExpr(){
		bonus = 0;
	}
	SalaryExpr(int bonus) {
		this.bonus = bonus;
	}
	int getSalary(int grade) {
		return bonus + 100 - (grade - 1) * 10;
	}
}

public class SalaryExam {

	public static void main(String[] args) {
		int month = (int)(Math.random() * 12) + 1;
		int grade = (int)(Math.random() * 4) + 1;
		SalaryExpr person;
		
		if (month % 2 == 0) {
			person = new SalaryExpr(100);
			System.out.printf("%d월 %d등급의 월급은 %d입니다.",month, grade, person.getSalary(grade));
		} else {
			person = new SalaryExpr();
			System.out.printf("%d월 %d등급의 월급은 %d입니다.",month, grade, person.getSalary(grade));
		}
	}
}
