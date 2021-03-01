package javaee.servlets;

import javaee.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/filter")
public class FilterStudentsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String iin = request.getParameter("iin");
        boolean isGrant = request.getParameter("grant").equals("YES");
        ArrayList<Student> filteredStudents = DBManager.findAllStudentsFilteredPaged(name, surname,
                iin, isGrant, 0, 10);

        request.setAttribute("filteredStudents", filteredStudents);
        request.getServletContext().getRequestDispatcher("/allStudents.jsp").forward(request, response);
    }
}
