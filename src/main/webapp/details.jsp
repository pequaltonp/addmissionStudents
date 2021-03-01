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
    <% Student student = DBManager.getStudent(Integer.parseInt(request.getParameter("id"))); %>
    <label for="n1">NAME:</label>
    <br>
    <b id="n1"><%= student.getName()%></b>
    <br><br>
    <label for="s1">SURNAME:</label>
    <br>
    <b id="s1"><%= student.getSurname()%></b>
    <br><br>
    <label for="m1">MIDDLE NAME:</label>
    <br>
    <b id="m1"><%= student.getMiddleName()%></b>
    <br><br>
    <label for="b1">BIRTHDATE:</label>
    <br>
    <b id="b1"><%= student.getBirthdate()%></b>
    <br><br>
    <label for="i1">IIN:</label>
    <br>
    <b id="i1"><%= student.getIin()%></b>
    <br><br>
    <label for="g1">IS GRANT:</label>
    <br>
    <b id="g1"><%= student.isGrant() ? "YES" : "NO"%></b>
    <br><br>
    <label for="p1">SPECIALTY:</label>
    <br>
    <b id="p1"><%= student.getSpeciality()%></b>
    <br><br>
    <a class="btn text-light" style="background-color: #6727b8"
       href="${pageContext.request.contextPath}/update?id=<%= request.getParameter("id")%>">EDIT</a>
</div>

</body>
</html>
