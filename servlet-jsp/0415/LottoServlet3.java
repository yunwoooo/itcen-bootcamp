package lab;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/lotto3")
public class LottoServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("cnt") == null) {
			session.setAttribute("cnt", new int[1]);
		}
		int[] count = (int[])session.getAttribute("cnt");
		count[0]++;
		System.out.println("당신은 "+ count[0] + "번째 방문입니다.");		
		if (count[0] > 3) {
			request.setAttribute("msg", "더 이상 응모할 수 없어요... 브라우저를 재기동한 후에는 가능하답니다.");
			request.getRequestDispatcher("/jspexam/lottoResult.jsp").forward(request, response);
			return;
		}
	
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
		request.getRequestDispatcher("/jspexam/lottoResult2.jsp").forward(request, response);
	}
}
