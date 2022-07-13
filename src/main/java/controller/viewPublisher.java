package controller;

import entity.Publisher;
import service.publisher.PublisherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/viewPublishers")
public class viewPublisher extends HttpServlet {
    PublisherService publisherService=new PublisherService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

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
        out.println("<tr><th>Username</th><th>Address</th><th>phoneNumber</th><th>Email</th><th>registered date</th></tr>");
        List<Publisher> all = null;
        try {
            all = publisherService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Publisher bean : all) {


            out.println("<tr><td>" + bean.getName() + "</td><td>" + bean.getAddress() + "</td><td>" + bean.getPhoneNumber() + "</td><td>" + bean.getEmail() + "</td><td>" + bean.getCreated_at() + "</td><td><a href='deletePublisher?id=" + bean.getId() + "'>Delete</a></td></tr>");

        }
        out.println("</table>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }
}
