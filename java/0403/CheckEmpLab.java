package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class CheckEmpLab {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		Connection conn = DriverManager.getConnection(url, user, passwd);
		Statement stmt = conn.createStatement();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("직원 이름을 입력하세요 : ");
			String ename = scan.nextLine();
			ResultSet rs = stmt.executeQuery("SELECT ename, year(hiredate), month(hiredate), deptno  FROM emp "
					+ "WHERE ename = '" + ename + "'"); 

			if (rs.next()) {
				do {
					System.out.printf("%s 직원은 근무중입니다.\n%d년 %d월에 입사했고 현재 %d번 부서에서 근무하고 있습니다.\n", 
                            rs.getString("ename"), rs.getInt("year(hiredate)"), rs.getInt("month(hiredate)"), rs.getInt("deptno"));
				} while (rs.next());
			} else {
				System.out.println(ename + " 직원은 근무하지 않습니다.");
			}
			
			rs.close();
			System.out.print("계속 검토하시겠습니까? (y/n) : ");
			String answer = scan.nextLine();
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		scan.close();
		stmt.close();
		conn.close();
	}
}
