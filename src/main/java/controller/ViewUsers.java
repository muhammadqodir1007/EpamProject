package controller;


import entity.PeopleBean;
import service.people.PeopleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/viewUsers")
public class ViewUsers extends HttpServlet {
    PeopleService peopleService = new PeopleService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") == null || !Login.name.equals("Alex")) {
            resp.sendRedirect("login.jsp");
        } else {


            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            try {
                List<PeopleBean> all = peopleService.getAll();
                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.println("<head>");
                out.println("<title>View News</title>");
                out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
                out.println("</head>");
                out.println("<body>");
                req.getRequestDispatcher("NavAdmin.html").include(req, resp);
                out.println("<div class='container' style=\"margin-left: 250px\">");
                out.println("<table class='table table-bordered table-striped'>");
                out.println("<tr><th>Username</th><th>fullName</th><th>Password</th><th>phone</th><th>email</th><th>registered date</th></tr>");


                for (PeopleBean bean : all) {


                    out.println("<tr><td>" + bean.getUsername() + "</td><td>" + bean.getFullName() + "</td><td>" + bean.getPassword() + "</td><td>" + bean.getPhoneNumber() + "</td><td>" + bean.getEmail() + "</td><td>" + bean.getCreatedAt() + "</td><td><a href='deleteUser?id=" + bean.getId() + "'>Delete</a></td></tr>");

                }
//
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");


        }
    }
}