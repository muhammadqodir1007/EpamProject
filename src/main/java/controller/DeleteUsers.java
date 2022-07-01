package controller;

import service.people.PeopleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteUser")
public class DeleteUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PeopleService peopleService=new PeopleService();
        try {
            peopleService.deleteById(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("/viewUsers");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
