package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.domain.MemberDTO;

@WebServlet("/member")
public class MemberServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberDTO member = new MemberDTO();
		
		member.setName(name == null || name.isEmpty() ? "없음" : name);
		member.setNumber(number == null || number.isEmpty() ? "없음" : number);
		member.setId(id == null || id.isEmpty() ? "없음" : id);
		member.setPassword(password == null || password.isEmpty() ? "없음" : password);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/jspexam/memberView.jsp").forward(request,response);
	}
}
