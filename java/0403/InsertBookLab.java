package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertBookLab {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		int count = 0;
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement("insert into book(title, price, kind) values (?, ?, ?)");
				Scanner scan = new Scanner(System.in);){
			while(true) {
				System.out.print("도서명을 입력하세요 : ");
				String title = scan.nextLine();
				System.out.print("가격을 입력하세요 : ");
				int price = Integer.parseInt(scan.nextLine());
				System.out.print("도서 분류에 대한 넘버를 입력하세요.\n"
						+ "\t1. 프로그래밍 언어\n"
						+ "\t2. 웹 프로그래밍"
						+ "\t3. 빅데이터"
						+ "\t4. 데이터베이스"
						+ "\t5. 인프라"
						+ "선택(1~5) : ");
				int kindNum = Integer.parseInt(scan.nextLine());
				pstmt.setString(1,  title);
				pstmt.setInt(2, price);
				pstmt.setString(3, "b0" + kindNum);
				pstmt.executeUpdate();
				System.out.println("정보가 입력되었습니다.");
				count++;
				System.out.print("계속 입력하겠습니까?(y/n)");
				String aws = scan.nextLine();
				if (aws.equalsIgnoreCase("y")) {
					continue;
				} 
				System.out.println(count + "개의 데이터 입력 완료!");
				break;
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 
	}
}
