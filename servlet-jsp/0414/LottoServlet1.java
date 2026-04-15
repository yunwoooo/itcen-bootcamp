package lab;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNum = Integer.parseInt(request.getParameter("num"));
		int random = (int)(Math.random() * 6) + 1;
		
		System.out.println("전달된 값 : " + userNum + ", 추출된 값 : " + random);
		if (userNum == random) {
			request.getRequestDispatcher("/clientexam/success.html").forward(request, response);
		} else {
			request.getRequestDispatcher("/clientexam/fail.html").forward(request, response);
			
		}
	}
}
