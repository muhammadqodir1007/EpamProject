<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>


<form action="${pageContext.request.contextPath}/admin" , method="post"  enctype="multipart/form-data" >


    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">Name</label>
            <input type="text"  name="name" class="form-control" id="inputEmail4" placeholder="Name">
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword4">Title</label>
            <input type="text" name="title" class="form-control" id="inputPassword4" placeholder="title">
        </div>
    </div>
    <div class="form-group">
        <label for="inputAddress">Description</label>
        <input type="text" name="description" class="form-control" id="inputAddress" placeholder="Description">
    </div>
    <div class="form-group">
        <label for="inputAddress2">Photo</label>
        <input type="file" class="form-control" id="inputAddress2"  name="photo" placeholder="photo">
    </div>




    <button type="submit" class="btn btn-primary">Add</button>





    </form>
</body>