<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application Error</title>

<style>

body{
    font-family: Arial, Helvetica, sans-serif;
    background:#f4f6f9;
    margin:0;
    padding:0;
}

.container{
    width:500px;
    margin:120px auto;
    background:white;
    padding:40px;
    text-align:center;
    border-radius:10px;
    box-shadow:0px 5px 15px rgba(0,0,0,0.2);
}

h1{
    color:#e74c3c;
    font-size:40px;
}

p{
    font-size:16px;
    color:#555;
}

.btn{
    display:inline-block;
    margin-top:20px;
    padding:10px 20px;
    background:#3498db;
    color:white;
    text-decoration:none;
    border-radius:5px;
}

.btn:hover{
    background:#2980b9;
}

.details{
    margin-top:20px;
    font-size:13px;
    color:#888;
}

</style>

</head>

<body>

<div class="container">

<h1>Oops!</h1>

<h2>Something went wrong</h2>

<p>
The page you requested encountered an error.
Please try again later or contact the administrator.
</p>

<a href="login.jsp" class="btn">Go Back to Home</a>

<div class="details">

<% if(exception != null){ %>

<p><strong>Error Message:</strong> <%= exception.getMessage() %></p>

<p><strong>Exception Type:</strong> <%= exception.getClass().getName() %></p>

<% } %>

</div>

</div>

</body>
</html>