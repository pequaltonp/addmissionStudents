<%@ page import="javaee.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="vendor/head.jsp"%>
    <title>Student Admission</title>
</head>
<body>
<%@include file="vendor/nav.jsp"%>
<div class="container">
    <br>
    <h2>EDIT STUDENT</h2>
    <br>
    <% if ("true".equals(request.getParameter("success"))) { %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>Successfully added!</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <%
    }
    if ("true".equals(request.getParameter("deleted"))) { %>
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>Successfully deleted!</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <%
    }

    Student student = new Student();
    if (request.getParameter("id") != null) {
        student = DBManager.getStudent(Integer.parseInt(request.getParameter("id")));
    }
    %>
    <form class="was-validated" action="/update"  method="post">
        <div class="form-group" style="display: none">
            <label>ID :</label>
            <input class="form-control" type="text" value="<%= student.getId()%>" name="id1" readonly>
        </div>
        <div class="form-group">
            <label>NAME :</label>
            <input type="text" class="form-control" name="name1"
                   value="<%= student.getName()%>" required>
            <div class="valid-feedback">Valid</div>
            <div class="invalid-feedback">Please fill out this field</div>
        </div>
        <div class="form-group">
            <label>SURNAME :</label>
            <input type="text" class="form-control" name="surname1"
                   value="<%= student.getSurname()%>" required>
            <div class="valid-feedback">Valid</div>
            <div class="invalid-feedback">Please fill out this field</div>
        </div>
        <div class="form-group">
            <label>MIDDLE NAME :</label>
            <input type="text" class="form-control"
                   value="<%= student.getMiddleName()%>" name="middleName1">
        </div>
        <div class="form-group">
            <label>BIRTHDATE :</label>
            <input type="date" class="form-control" name="birthdate1"
                   value="<%= student.getBirthdate()%>" required>
            <div class="valid-feedback">Valid</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label>IIN :</label>
            <input type="text" class="form-control" name="iin1"
                   value="<%= student.getIin()%>" required>
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

        <div class="clearfix">
            <button class="btn text-light float-left" type="submit" style="background-color: #6727b8">SAVE</button>
            <form action="/delete" method="get">
            <div class="clearfix">
                <a class="btn btn-danger text-light float-right"
                   href="${pageContext.request.contextPath}/delete?id=<%= student.getId()%>">DELETE</a>
            </div>
        </form>
        </div>
    </form>

</div>

</body>
</html>
