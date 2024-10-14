<!DOCTYPE html>
<html lang="en">
<head>
<link href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet" >

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
<nav class="navbar bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand">Todo</a>


    <form class="d-flex" role="search">
      <a class="btn btn-outline-success" href="/logout">LogOut</a>
    </form>

  </div>

</nav>
  <hr style="background-color: #333; height: 4px;">

<div class="container">


<h1> Welcome To Todo </h1>
<h3>Mr. ${name}</h3>
<a href="list-todos">Manage</a> your todos

</div>
</body>
</html>