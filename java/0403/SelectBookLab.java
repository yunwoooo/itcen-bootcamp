package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectBookLab {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();
				Scanner scan = new Scanner(System.in);){
			
			while(true) {
				System.out.print("1. 모두 출력하기\n"
						+ "2. 가격이 높은 순으로 출력하기\n"
						+ "3. 20000 이상의 도서들만 출력하기\n"
						+ "4. 웹 프로그래밍 도서들만 출력하기\n"
						+ "5. 데이터베이스와 인프라 도서들만 출력하기\n"
						+ "6. 도서명에 '자바'를 포함하는 도서들만 출력하기\n\n"
						+ "원하는 메뉴의 번호를 선택 : ");
				int num = Integer.parseInt(scan.nextLine());
				
				if (num == 1) {
					ResultSet rs = stmt.executeQuery("select id, title, price, kind from book");
					while(rs.next()) {
						System.out.printf("%d\t%s\t%,d원\t%s\n", rs.getInt("id"), rs.getString("title"), rs.getInt("price"), rs.getString("kind"));
					}
					 rs.close();
				} else if (num == 2) {
					ResultSet rs = stmt.executeQuery("select id, title, price, kind from book order by price desc");
					while(rs.next()) {
						System.out.printf("%d\t%s\t%,d원\t%s\n", rs.getInt("id"), rs.getString("title"), rs.getInt("price"), rs.getString("kind"));
					}
					rs.close();
				} else if (num == 3) {
					ResultSet rs = stmt.executeQuery("select title, price from book where price >= 20000");
					while(rs.next()) {
						System.out.printf("%s\t%,d원\n", rs.getString("title"), rs.getInt("price"));
					}
					rs.close();
				} else if (num == 4) {
					ResultSet rs = stmt.executeQuery("select title, price from book where kind = 'b02'");
					while(rs.next()) {
						System.out.printf("%s\t%,d원\n", rs.getString("title"), rs.getInt("price"));
					}
					rs.close();
				} else if (num == 5) {
					ResultSet rs = stmt.executeQuery("select title, price from book where kind = 'b04' or 'b05' ");
					while(rs.next()) {
						System.out.printf("%s\t%,d원\n", rs.getString("title"), rs.getInt("price"));
					}
					rs.close();
				} else if (num == 6) {
					ResultSet rs = stmt.executeQuery("select title, price from book where title like '%자바%'");
					while(rs.next()) {
						System.out.printf("%s\t%,d원\n", rs.getString("title"), rs.getInt("price"));
					}
					rs.close();
				} 
				
				
				System.out.print("계속 입력하겠습니까?(y/n)");
				String aws = scan.nextLine();
				if (aws.equalsIgnoreCase("y")) {
					continue;
				} 
				System.out.print("프로그램 종료");
				break;
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 
	}
}
