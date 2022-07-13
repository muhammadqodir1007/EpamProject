package controller;

import entity.PeopleBean;
import service.people.PeopleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")

public class AddUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username")==null){
            resp.sendRedirect("login.jsp");
        }else
        {
            resp.sendRedirect("addUser.html");
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phoneNumber");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(fullName);
        System.out.println(email);
        System.out.println(phoneNumber);
        System.out.println(password);

        PeopleBean bean = new PeopleBean(username,fullName,password,phoneNumber,email);
        bean.setEmail(email);
        bean.setPassword(password);
        bean.setUsername(username);
        bean.setPhoneNumber(phoneNumber);
        bean.setFullName(fullName);

        PeopleService peopleService = new PeopleService();
        int i = peopleService.addUser(bean);
        if (i!=0){
            resp.sendRedirect("addUser");
        }





    }
}
