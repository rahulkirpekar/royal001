<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Web Application</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    min-height:100vh;
    display:flex;
    flex-direction:column;
}

.main-content{
    flex:1;
}

</style>

</head>

<body>

<!-- Navbar -->

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

<div class="container">

<a class="navbar-brand fw-bold" href="#">MyApp</a>

<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu">
<span class="navbar-toggler-icon"></span>
</button>

<div class="collapse navbar-collapse" id="menu">

<ul class="navbar-nav ms-auto">

<li class="nav-item">
<a class="nav-link" href="#">Home</a>
</li>

<li class="nav-item">
<a class="nav-link" href="#">About</a>
</li>

<li class="nav-item">
<a class="nav-link" href="#">Services</a>
</li>

<li class="nav-item">
<a class="nav-link" href="#">Contact</a>
</li>

</ul>

</div>

</div>

</nav>

<div class="container mt-5 main-content">