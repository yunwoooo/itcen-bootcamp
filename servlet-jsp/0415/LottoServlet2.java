package lab;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNum = Integer.parseInt(request.getParameter("num"));
		int random = (int)(Math.random() * 6) + 1;
		
		System.out.println("전달된 값 : " + userNum + ", 추출된 값 : " + random);
		if (userNum == random) {
			request.setAttribute("msg", "당첨~~~ 추카추카");
		    request.setAttribute("imginfo", "https://cdn.univ20.com/files/ade_bihv59.png");
		} else {
			request.setAttribute("msg", "실패~~~ 아쉽아쉽");
	        request.setAttribute("imginfo", "https://pbs.twimg.com/media/Ep7POt-VQAAeG54.jpg");
		}
		request.getRequestDispatcher("/jspexam/lottoResult.jsp").forward(request, response);
	}
}
