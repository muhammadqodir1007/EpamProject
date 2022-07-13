package controller;

import service.publisher.PublisherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("")
public class Login extends HttpServlet {
   public static String name;

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
//        if (PublisherService.getPublisher(name).getName().equals("")){
//            resp.sendRedirect("Wrong.html");
//        }

        if(name.equals("Alex")&&password.equals("Lee")){
            HttpSession httpSession= req.getSession();
            httpSession.setAttribute("username",name);
            resp.sendRedirect("Home.jsp");


        }else if (PublisherService.getPublisher(name).getPassword().equals(password)){

            resp.sendRedirect("Wrong.html");

        }


    }
}
