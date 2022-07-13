package controller;

import entity.Publisher;
import service.publisher.PublisherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/addPublisher")
public class AddPublisher extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("addPublisher.html");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(name);
        System.out.println(address);
        System.out.println(phoneNumber);
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisher.setAddress(address);
        publisher.setPhoneNumber(phoneNumber);
        publisher.setEmail(email);
        publisher.setPassword(password);
        publisher.setCreated_at(date);
        PublisherService publisherService = new PublisherService();
        try {
            int i = publisherService.addPublisher(publisher);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
