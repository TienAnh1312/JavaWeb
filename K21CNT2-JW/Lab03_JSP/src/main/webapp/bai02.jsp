<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hiển thị ngày tháng hiện tại</title>
</head>
<body>
	<h1>BuiTienAnh - JSP</h1>
	<hr/>
	<% Date date = new Date(); %>
	<p>Hôm nay là: ngày <%=date.getDate() %> 
				   tháng <%=date.getMonth()+1 %>
				   năm <%=date.getYear()+1900 %>
	</p>
	<p> Bây giờ là:
		<%=date.getHours() %> 
		<%=date.getMinutes() %> 
		<%=date.getSeconds() %> 
	</p>
	
</body>
</html>