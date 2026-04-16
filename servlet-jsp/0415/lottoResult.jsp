<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
        String msg = (String) request.getAttribute("msg");
        String imginfo = (String) request.getAttribute("imginfo");
    %>

    <h1 style="color: red"><%= msg %></h1>

    <% if (imginfo != null) { %>
        <img src="<%= imginfo %>" alt="결과이미지" style="width : 700px">
    <% } %>

    <% if (msg != null && msg.contains("실패")) { %>
        <br>
        <a href="clientexam/lottoForm2.html" style="color:red">로또 응모</a>
    <% } %>
</body>
</html>