package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		boolean random = new Random().nextBoolean();
		Connection conn = DriverManager.getConnection(url, user, passwd);
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select ename, sal, year(hiredate), month(hiredate),  day(hiredate) from emp order by hiredate desc");  // 없으면 비어있는 result set 반환
		
		if (rs.next()) {
			while (rs.next()) {
				if (random) {
					System.out.printf("%s 직원의 월급은 %,d달러입니다.\n", 
							rs.getString("ename"), rs.getInt("sal"));
				} else {
					System.out.printf("%s 직원은 %d년 %d월 %d일에 입사하였습니다.\n", 
							rs.getString("ename"), rs.getInt("year(hiredate)"), rs.getInt("month(hiredate)"), rs.getInt("day(hiredate)"));
				}
				
			}
		}
		rs.close();
		stmt.close();
		conn.close();
			

	}

}
