<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="vendor/head.jsp"%>
    <title>Student Admission</title>

</head>
<body>
<%@include file="vendor/nav.jsp"%>

<div class="container">
    <h2>ADD STUDENT</h2>
    <% if ("true".equals(request.getParameter("success"))) { %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>Successfully added!</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <%
    }
    %>
    <form class="was-validated"  action="/add"  method="post">
        <div class="form-group">
            <label>NAME :</label>
            <input type="text" class="form-control" name="name1" required>
            <div class="valid-feedback">Valid</div>
            <div class="invalid-feedback">Please fill out this field</div>
        </div>
        <div class="form-group">
            <label>SURNAME :</label>
            <input type="text" class="form-control" name="surname1" required>
            <div class="valid-feedback">Valid</div>
            <div class="invalid-feedback">Please fill out this field</div>
        </div>
        <div class="form-group">
            <label>MIDDLE NAME :</label>
            <input type="text" class="form-control" name="middleName1">
        </div>
        <div class="form-group">
            <label>BIRTHDATE :</label>
            <input type="date" class="form-control" name="birthdate1" required>
            <div class="valid-feedback">Valid</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label>IIN :</label>
            <input type="text" class="form-control" name="iin1" required>
            <div class="valid-feedback">Valid</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="grant">IS GRANT :</label>
            <select class="form-control" id = "grant" name="grant1">
                <option>YES</option>
                <option>NO</option>
            </select>
        </div>
        <div class="form-group">
            <label>SPECIALTY :</label>
            <select class="form-control" name="specialty1">
                <option>Information Technologies</option>
                <option>Computer Science</option>
                <option>Mech Math</option>
                <option>Information Security</option>
                <option>Journalism</option>
                <option>Finance</option>
                <option>Management</option>
                <option>RET</option>
            </select>
        </div>
        <button class="btn text-light" type="submit" style="background-color: #6727b8">ADD</button>
    </form>
</div>

</body>
</html>
