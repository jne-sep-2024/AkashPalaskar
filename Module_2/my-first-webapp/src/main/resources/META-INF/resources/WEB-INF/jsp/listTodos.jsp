<%@ taglib  prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="en">
<head>
<link href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet" >
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Todos Pages</title>
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


<h1>Its Your Todos ${name} </h1>

<table class="table">

    <thead>
        <th>Description</th>
        <th>Target Date</th>
        <th>Is Done?</th>
        <th></th>
        <th></th>

    </thead>

    <tbody>
<c:forEach items="${todos}" var="todo">
<tr>
    <td>${todo.description}</td>
    <td>${todo.targetDate}</td>
    <td>${todo.done}</td>

    <td><a href="update-todo?id=${todo.id}" class="btn btn-warning">Update</a></td>

    <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>

</tr>
</c:forEach>
</tbody>
</table>

<a href="add-todo" class="btn btn-success"> Add_Todo</a>
</div>

<script src="/webjars/bootstrap/5.3.2/js/bootstrap.min.js"> </script>
<script src="/webjars/jquery/3.7.0/jquery.js"> </script>

</body>
</html>