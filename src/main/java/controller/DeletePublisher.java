package controller;

import service.publisher.PublisherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deletePublisher")
public class DeletePublisher extends HttpServlet {

    PublisherService publisherService=new PublisherService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            publisherService.deletebyid(Integer.parseInt(req.getParameter("id")));
            // resp.sendRedirect("viewPublishers");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("viewPublishers");
    }
}
