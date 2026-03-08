<?xml version="1.0" encoding="UTF-8" ?>

<%@page errorPage="errorpage.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>
	<%@page errorPage="errorpage.jsp" %>

	<%@include file="header.jsp" %>
	
	<div class="card shadow p-4">
	
	<h2 class="mb-3">Welcome to JSP Example</h2>
	
	<%
	    int no1 = 10;
	    int no2 = 5;
	
	    int ans = no1/no2;
	
	    out.print("<h4 class='text-success'>Result : " + ans + "</h4>");
	%>
	
	</div>
	
	<%@include file="footer.jsp" %>
</body>
</html>
