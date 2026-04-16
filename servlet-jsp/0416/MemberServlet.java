package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.domain.MemberDTO;

@WebServlet("/member")
public class MemberServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		if(session.getAttribute("member") == null) {
			session.setAttribute("member", new MemberDTO());
		}
		MemberDTO m = (MemberDTO)session.getAttribute("member");
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		m.setName(name == null || name.isEmpty() ? "없음" : name);
		m.setNumber(number == null || number.isEmpty() ? "없음" : number);
		m.setId(id == null || id.isEmpty() ? "없음" : id);
		m.setPassword(password == null || password.isEmpty() ? "없음" : password);
		request.getRequestDispatcher("/jspexam/memberView.jsp").forward(request,response);
	}
}
