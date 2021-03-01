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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student student = DBManager.getStudent(Integer.parseInt(request.getParameter("id1")));

        int[] date = Arrays.stream(request.getParameter("birthdate1").split("-"))
                .mapToInt(Integer::parseInt).toArray();

        student.setName(request.getParameter("name1").trim());
        student.setSurname(request.getParameter("surname1").trim());
        student.setBirthdate(LocalDate.of(date[0], date[1], date[2]));
        student.setMiddleName(request.getParameter("middleName1"));
        student.setGrant(request.getParameter("grant1").equals("YES"));
        student.setSpeciality(request.getParameter("specialty1"));
        student.setIin(request.getParameter("iin1"));

        if (DBManager.saveStudent(student))
        {
            response.sendRedirect("/edit.jsp?success=true");
        }
        else {
            response.sendRedirect("/edit.jsp?success=false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }
}
