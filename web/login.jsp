<%--
  Created by IntelliJ IDEA.
  User: Muhammadqodir
  Date: 7/9/2022
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">

</head>
<body style="margin: 40px">
<form action="/"
      style="text-align: center ; width: 500px ; border-radius: 50px; margin-left: 500px ; margin-top: 100px "
      method="post">

    <div class="form-outline mb-4">
        <input type="text" id="form2Example1" class="form-control" name="name" required style="border-radius: 30px"/>
        <label class="form-label" for="form2Example1">USERNAME</label>
    </div>


    <div class="form-outline mb-4">
        <input type="password" id="form2Example2" class="form-control" name="password" style="border-radius: 30px" id="validationCustom05"
               required/>
        <label class="form-label" for="form2Example2">PASSWORD</label>
    </div>


    <!-- Submit button -->
    <input type="submit">

</form>
</body>
</html>
