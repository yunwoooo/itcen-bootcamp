<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.domain.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보</h1>
<hr>
	<%
		MemberDTO member = (MemberDTO)request.getAttribute("member");
	%>
	<ul>
		<li>회원 이름 : <%=member.getName()%></li>
		<li>회원 계정 : <%=member.getId()%></li>
		<li>회원 암호 : <%=member.getPassword()%></li> 
		<li>회원 전화번호 : <%=member.getNumber()%></li>
	</ul>
	<ul>
		<li>회원 이름 : ${member.name}</li>
		<li>회원 계정 : ${member.id}</li>
		<li>회원 암호 : ${member.password}</li>
		<li>회원 전화번호 : ${member.number}</li>
	</ul>
</body>
</html>