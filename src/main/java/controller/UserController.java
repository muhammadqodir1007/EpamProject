package controller;

import entity.EmailConfir;
import payload.UserDto;
import service.email.EmailServices;
import service.users.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/sendEmail", "/login"})
public class UserController extends HttpServlet {
    private EmailServices emailServices;
    private UserService userService;
    private static final long serialVersionUID = 1L;

    public void init() {
        emailServices = new EmailServices();
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/sendEmail":
                    sendEmail(request, response);
                    break;
                case "/login":
                    authenticate(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    protected void sendEmail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String email = request.getParameter("emailing");
//                saving data base
        EmailConfir confir = new EmailConfir(email);
        int numb = emailServices.saveEmail(confir);
        if (numb > 0) {
//                    result = numb;
            request.setAttribute("natija", true);
        } else {
            request.setAttribute("natija", false);
        }
        response.sendRedirect("/");
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("logusername");
        String password = request.getParameter("logpassword");
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setPassword(password);
        System.out.println(username);
        System.out.println(password);
        if (userService.validate(userDto)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("currentSession", userDto);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("currentSession", null);
            request.setAttribute("result", false);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/");
            dispatcher.forward(request, response);
        }
    }
}
