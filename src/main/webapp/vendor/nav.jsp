<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <title>Student Admission</title>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #6727b8">
    <h3 class="navbar-brand">INTERNATIONAL UNIVERSITY</h3>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/allStudents.jsp">All Students</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/addStudent.jsp">Add Student</a>
        </li>
    </ul>
</nav>
</body>
</html>
