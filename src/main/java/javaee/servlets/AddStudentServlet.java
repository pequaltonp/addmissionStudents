package javaee.servlets;

import javaee.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;


@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int[] date = Arrays.stream(request.getParameter("birthdate1").split("-"))
                .mapToInt(Integer::parseInt).toArray();

        Student student = new Student(
                request.getParameter("name1").trim(),
                request.getParameter("surname1").trim(),
                request.getParameter("middleName1").trim(),
                LocalDate.of(date[0],date[1],date[2]),
                request.getParameter("iin1").trim(),
                request.getParameter("grant1").equals("YES"),
                request.getParameter("specialty1"));

        if (DBManager.addStudent(student)) {
            response.sendRedirect("/addStudent.jsp?success=true");
        }
        else {
            response.sendRedirect("/addStudent.jsp?success=false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
