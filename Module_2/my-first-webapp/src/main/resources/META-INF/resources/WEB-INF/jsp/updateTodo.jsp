<%@ taglib  prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
<link href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet" >

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Todo  page</title>
</head>
<body>
<div class="container">
<h1>Enter Todo Details</h1>
    <form:form method="post" modelAttribute="todo">
        <form:errors  path ="description" cssClass="text-warning"/>
<br>
     Id;  <form:input type="text" name ="description"   path="id"   />

       Description ${id}: <form:input type="text" name ="description"   path="description"  required="required" />

   Target Date:   <form:input type="text" name ="description"   path="targetDate"   />
       Done: <form:input type="text" name ="description"   path="done"   />
      <input type="submit" class="btn btn-success"/>

    </form:form>
</div>

<script src="/webjars/bootstrap/5.3.2/js/bootstrap.min.js"> </script>
<script src="/webjars/jquery/3.7.0/jquery.js"> </script>

</body>
</html>