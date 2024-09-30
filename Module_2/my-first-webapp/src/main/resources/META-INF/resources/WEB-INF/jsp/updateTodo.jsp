<%@ taglib  prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
<link href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet" >
<link href="/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.css" rel="stylesheet" >

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Todo  page</title>
</head>
<body>
<div class="container">
<h1>Enter Todo Details</h1>
    <form:form method="post" modelAttribute="todo">
         <fieldset class="mb-3">

                  <form:label  path="description">Description : </form:label>
                   <form:input type="text" path="description"  required="required" />    <br>
                   <form:errors  path ="description" cssClass="text-warning"/>

           </fieldset>

        <fieldset class="mb-3">

               <form:label  path="targetDate">Target Date: </form:label>
                <form:input type="text" path="targetDate"  required="required" /> <br>
             <form:errors  path ="targetDate" cssClass="text-warning"/>

        </fieldset>
      <input type="submit" class="btn btn-success"/>

    </form:form>
</div>

<script src="/webjars/bootstrap/5.3.2/js/bootstrap.min.js"> </script>
<script src="/webjars/jquery/3.7.0/jquery.js"> </script>
<script src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"> </script>

    <!-- <script type="text/javascript">$('#targetDate').datepicker({formate:'yyyy-mm-dd'}) </script> -->

</body>
</html>
