package lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/visitor")
public class visitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("name");
		String content = request.getParameter("content");
		LocalDate date = LocalDate.now();
		
		out.print("<h1>" + userName + "님이 " 
						+ date.getYear() + "년 " + date.getMonthValue() + "월 " + date.getDayOfMonth() + "일"
						+ "에 남긴 글입니다.</h1>");
		out.print("<hr>");
		out.print("<h2>" + content + "</h2>");
		
		out.print("<a href='"+request.getHeader("referer")+"'>입력화면으로 가기</a>");
		out.close();
	}
}
