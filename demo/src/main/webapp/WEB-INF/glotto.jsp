<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title here</title>
</head>
<body>
	<%!
		String str = "나는 include 된 페이지다아~!";
	%>
	<% out.println(str + "<br/>"); %>
</body>
</html>