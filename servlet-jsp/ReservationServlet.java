package lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String room = request.getParameter("room");
		String option[] = request.getParameterValues("option");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		out.print("<h1 style='color:blue'>" + name + "님의 예약 내용 </h1>");
		out.print("<hr>");
		out.print("<ul>");
		out.print("<li>선택한 룸 : "+ room +"</li>");
		if (option != null && option.length != 0) {
			out.print("<li>추가 요청 사항 : ");
			for (int i = 0; i < option.length; i++) 
			    out.print(i != option.length - 1 ? option[i] + ", " : option[i] );
			out.print("</li>");	
		} else {
			out.print("<li>추가 요청사항이 없군요..</li>");
		}
		out.print("<li>예약날짜 : "+ date.getYear() + "년 "+ date.getMonthValue() + "월 " + date.getDayOfMonth() + "일"+"</li>");
		out.print("</ul>");
		
		out.close();
	}
}
