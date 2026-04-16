package emp;

public class Company {
	public static void main(String[] args) {
		Employee[] employee = new Employee[2];
		employee[0] = new Secretary("Duke", 1, "secretary", 800);
		employee[1] = new Sales("Tuxi", 2, "sales", 1200);
		printEmployee(employee, false);
		
		System.out.println();
		System.out.println("[인센티브 100 지급]");
		((Secretary)employee[0]).incentive(100);
		((Sales)employee[1]).incentive(100);
		printEmployee(employee, true);
		
	}
	public static void printEmployee(Employee[] emp, boolean isTax) {
		if (!isTax) {
			System.out.println("name \t department \t salary \t extra pay");
			System.out.println("-------------------------------------------------");
			for (int i = 0; i < emp.length; i++)
				if (emp[i] instanceof Sales)
					System.out.printf("%s \t %s \t %d \t %f \n", emp[i].getName(), emp[i].getDepartment(), emp[i].getSalary(), ((Sales)emp[i]).getExtraPay());
				else
					System.out.printf("%s \t %s \t %d\n", emp[i].getName(), emp[i].getDepartment(), emp[i].getSalary());
			
		} else {
			System.out.println("name\tdepartment\tsalary\ttax\textra pay");
			System.out.println("----------------------------------------------------------");
			for (int i = 0; i < emp.length; i++)
				if (emp[i] instanceof Sales)
					System.out.printf("%s \t %s \t %d \t %f \t %f \n", emp[i].getName(), emp[i].getDepartment(), emp[i].getSalary(), emp[i].tax(), ((Sales)emp[i]).getExtraPay());
				else
					System.out.printf("%s \t %s \t %d \t %f \n", emp[i].getName(), emp[i].getDepartment(), emp[i].getSalary(), emp[i].tax());
		}
	}
}
