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
		MemberDTO member1 = (MemberDTO)session.getAttribute("member");
	%>
	<ul>
		<li>회원 이름 : <%=member1.getName()%></li>
		<li>회원 계정 : <%=member1.getId()%></li>
		<li>회원 암호 : <%=member1.getPassword()%></li> 
		<li>회원 전화번호 : <%=member1.getNumber()%></li>
	</ul>
	<ul>
		<li>회원 이름 : ${sessionScope.member.name}</li>
		<li>회원 계정 : ${sessionScope.member.id}</li>
		<li>회원 암호 : ${sessionScope.member.password}</li>
		<li>회원 전화번호 : ${sessionScope.member.number}</li>
	</ul>
</body>
</html>