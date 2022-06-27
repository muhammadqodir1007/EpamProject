package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
   public static String name;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         name = req.getParameter("name");
        System.out.println(name);

        String password = req.getParameter("password");
        System.out.println(password);
        if(name.equals("Alex")&&password.equals("Lee")){
            resp.sendRedirect("Home.html");


        }else{
            resp.sendRedirect("addNews.html");

        }


    }
}
