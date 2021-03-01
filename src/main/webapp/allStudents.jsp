<%@ page import="javaee.*, java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="vendor/head.jsp"%>
    <title>Student Admission</title>
</head>
<body>
<%@include file="vendor/nav.jsp"%>
<nav class="navbar navbar-expand-sm bg-light">
    <form class="form-inline" action="/filter" method="get">
        <label for="name1" class="mb-2 mr-sm-4">Name:</label>
        <input type="text" class="form-control mb-2 mr-sm-5" id="name1" placeholder="Enter Name" name="name">
        <label for="lastname" class="mb-2 mr-sm-4">Surname:</label>
        <input type="text" class="form-control mb-2 mr-sm-5" id="lastname" placeholder="Enter Surname" name="surname">
        <label for="iin11" class="mb-2 mr-sm-4">IIN:</label>
        <input type="text" class="form-control mb-2 mr-sm-5" id="iin11" placeholder="Enter IIN" name="iin">
        <div class="form-group">
            <label for ="selectGrant" class="mb-2 mr-sm-4">Is Grant:</label>
            <select class="form-control mb-2 mr-sm-5" id="selectGrant" name="grant">
                <option>YES</option>
                <option>NO</option>
            </select>
        </div>
        <button type="submit" class="btn text-light mb-2" style="background-color: #6727b8">Filter</button>
    </form>
</nav>

<div class="container">
    <br>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>SURNAME</th>
            <th>IIN</th>
            <th>BIRTHDATE</th>
            <th>IS GRANT</th>
            <th>DETAILS</th>
        </tr>
        </thead>
        <%
            ArrayList<Student> students = DBManager.selectAll();
            if (request.getAttribute("filteredStudents") != null) {
                students = (ArrayList<Student>) request.getAttribute("filteredStudents");
            }

            for (Student student: students) {
        %>
        <tbody>
        <tr>
            <td><%= student.getId()%></td>
            <td><%= student.getName()%></td>
            <td><%= student.getSurname()%></td>
            <td><%= student.getIin()%></td>
            <td><%= student.getBirthdate()%></td>
            <td><%= student.isGrant() ? "YES" : "NO"%></td>
            <td><a class="btn text-light" style="background-color: #6727b8"
                   href="details.jsp?id=<%= student.getId()%>">DETAILS</a></td>
        </tr>
        </tbody>
        <% } %>
    </table>
</div>

</body>
</html>
