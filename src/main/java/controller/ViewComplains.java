package controller;

import entity.Complain;
import entity.PeopleBean;
import entity.Publisher;
import service.complain.ComplainService;
import service.people.PeopleService;
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

@WebServlet("/viewComplains")
public class ViewComplains extends HttpServlet {

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
        out.println("<tr><th>message</th><th>User</th><th>Publisher</th></tr>");
        ComplainService Compl = new ComplainService();
        List<Complain> all = null;
        try {
            all = Compl.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        for (Complain complain : all) {
            PublisherService publisherService = new PublisherService();

            PeopleService peopleService = new PeopleService();
            PeopleBean user = null;
            try {
                user = peopleService.getOneById(complain.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Publisher publisher = null;


            try {
                publisher = publisherService.getOneById(complain.getPublisher_id());
            } catch (SQLException e) {
                e.printStackTrace();
            }


            out.println("<tr><td>" + complain.getMessage() + "</td><td>" + user.getFullName() + "</td><td>" + publisher.getUsername() + "</td><td><a onclick=\"myfunction()\"  href='blockById?id=" + publisher.getId() + "'>Block</a></td></tr>");

        }
//

            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("<script>\n" +
                    "    function myfunction(){\n" +
                    "        alert(\"Blocked\")\n" +
                    "    }\n" +
                    "</script>");
            out.println("</html>");


}
}
