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
        if (req.getSession().getAttribute("username") == null|| ! Login.name.equals("Alex")) {
            resp.sendRedirect("login.jsp");
        }else {
            resp.sendRedirect("addPublisher.html");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("nameOfCompany");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String description = req.getParameter("description");
        String username = req.getParameter("username");




        Date date = new Date(System.currentTimeMillis());
        Publisher publisher = new Publisher();
        publisher.setUsername(username);
        publisher.setDescription(description);
        publisher.setNameOfCompany(name);
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
