package controller;

import entity.Publisher;
import service.publisher.PublisherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("")
public class Login extends HttpServlet {
    public static String name;
    public static Publisher publisher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name = req.getParameter("name");
        System.out.println(name);

        String password = req.getParameter("password");
        System.out.println(password);

        if (name.equals("Alex") && password.equals("Lee")) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username", name);
            resp.sendRedirect("Home.jsp");


        }else {
        try {
            boolean existByName = PublisherService.existByName(Login.name);
            if (existByName) {

                Publisher publisher1 = PublisherService.getPublisher(Login.name);
                System.out.println(publisher1.getPassword());
                boolean blocked = PublisherService.getPublisher(Login.name).isBlocked();
                if (publisher1.getPassword().equals(password)&&!blocked) {
                    HttpSession httpSession = req.getSession();
                    httpSession.setAttribute("username", name);
                    publisher = publisher1;
                    resp.sendRedirect("HomeP.jsp");

                }else {
                    resp.sendRedirect("/");
                }

            } else {
                resp.sendRedirect("login.jsp");

            }

        } catch (SQLException e) {
            resp.sendRedirect("login.jsp");
        }


    }}
}
