<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.royal.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>List of Student Records</title>
</head>
<body>
		<h3>List of Student Records</h3>
		
		<%
			ArrayList<StudentBean> list = (ArrayList<StudentBean>)request.getAttribute("list");
		
		%>
		
		
</body>
</html>
