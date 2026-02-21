<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Application</title>

<style>

body{
    margin:0;
    padding:0;
    font-family: Arial, Helvetica, sans-serif;
    background: linear-gradient(135deg,#4facfe,#00f2fe);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.login-container{
    background:white;
    padding:40px;
    border-radius:10px;
    box-shadow:0px 10px 25px rgba(0,0,0,0.2);
    width:320px;
}

.login-container h2{
    text-align:center;
    margin-bottom:25px;
    color:#333;
}

.input-group{
    margin-bottom:15px;
}

.input-group label{
    display:block;
    font-weight:bold;
    margin-bottom:5px;
}

.input-group input{
    width:100%;
    padding:10px;
    border:1px solid #ccc;
    border-radius:5px;
    font-size:14px;
}

.login-btn{
    width:100%;
    padding:12px;
    border:none;
    border-radius:5px;
    background:#4facfe;
    color:white;
    font-size:16px;
    cursor:pointer;
    transition:0.3s;
}

.login-btn:hover{
    background:#008cff;
}

</style>

</head>

<body>

<div class="login-container">

    <h2>Login</h2>

    <form action="LoginServlet" method="post">

		${logoutSuccess}
		${logoutErr}
		
        <div class="input-group">
            <label>User Name</label>
            <input type="text" name="userName" required>
        </div>

        <div class="input-group">
            <label>Password</label>
            <input type="password" name="password" required>
        </div>

        <input type="submit" value="Login" class="login-btn">

    </form>

</div>

</body>
</html>