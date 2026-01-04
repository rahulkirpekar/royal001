<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Web Application</title>
</head>
<body>
	<h1>I am Jsp(Java Server Page)</h1>
	
	Scriptlet Tag :-
	<% 
		int no = 5;
		for(int i = 1 ;i <=10;i++)
		{
			out.println(no+" * " + i + " = " + (no*i)+"<br>");	
		}
	%>
	
	
	Expression Tag:-
	
	<%="Royal Technosoft Private Limited"%> <br>
	
	Addition : <%= 200+100 %>

<br>
	
	Declaration Tag:-
	
	<%!
		int getCube(int no)
		{
			return (no*no*no);
		}
	%>

<br>
	<%
		int ans = getCube(10);

		out.print("Cube of 10 : " + ans);
	%>
<br>

	Cube of 10 : <%= getCube(10) %>

	
	
</body>
</html>