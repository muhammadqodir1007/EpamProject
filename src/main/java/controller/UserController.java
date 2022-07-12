package controller;

import com.google.gson.Gson;
import entity.EmailConfir;
import entity.Users;
import org.apache.tomcat.util.codec.binary.Base64;
import payload.UserDto;
import service.email.EmailServices;
import service.users.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

@WebServlet(urlPatterns = {"/sendEmail", "/registration",
        "/showRegister", "/login", "/logout","/userSetting"})
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
                case "/logout":
                    calcelAuthentication(request, response);
                    break;
                case "/showRegister":
                    showRegister(request, response);
                    break;
                case "/registration":
                    register(request, response);
                    break;
                case "/userSetting":
                    setting(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void sendEmail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String email = request.getParameter("emailing");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                EmailConfir confir = new EmailConfir(email);
                int numb = emailServices.saveEmail(confir);
                if (numb > 0) {
//                    result = numb;
                    request.setAttribute("natija", true);
                } else {
                    request.setAttribute("natija", false);
                }
            }
        });
        thread.start();
        response.sendRedirect("/");
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String username = request.getParameter("logusername").trim();
        String password = request.getParameter("logpassword").trim();
        String remember = request.getParameter("remember");
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setPassword(password);

        if (userService.validate(userDto)) {
            Users users = userService.getUserDetails(userDto);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("userSession", users);
            Cookie cookieUser = new Cookie("cocUser", username);
            Cookie cookiePas = new Cookie("cocPas", password);
            Cookie cookieRem = new Cookie("cocRem", remember);
            cookieUser.setMaxAge(60 * 60);
            cookiePas.setMaxAge(60 * 60);
            cookieRem.setMaxAge(60 * 60);
            response.addCookie(cookieUser);
            response.addCookie(cookiePas);
            response.addCookie(cookieRem);

            httpSession.setAttribute("sessUser", username.trim());
            response.sendRedirect("/");
        } else {
            request.setAttribute("falseUser", false);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/");
            dispatcher.forward(request, response);
        }

    }

    private void calcelAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Cookie cUserName = new Cookie("cocUser", null);
        Cookie cPassword = new Cookie("cocPas", null);
        Cookie cRemember = new Cookie("cocRem", null);
        cUserName.setMaxAge(0);
        cPassword.setMaxAge(0);
        cRemember.setMaxAge(0);
        response.addCookie(cUserName);
        response.addCookie(cPassword);
        response.addCookie(cRemember);
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        response.sendRedirect("/");
    }

    private void showRegister(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("register/registration.jsp");
        dispatcher.forward(request, response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String username = request.getParameter("username");
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");

        Users users = new Users();
        users.setUsername(username);
        users.setFullName(fullName);
        users.setPassword(password);
        users.setPhoneNumber(phoneNumber);
        users.setEmail(email);

        try {
            if (userService.isUserExist(users)) {
                request.setAttribute("msg", false);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/showRegister");
                dispatcher.forward(request, response);

            } else {
                int result = userService.saveUser(users);
                if (result == 2) {
                    request.setAttribute("result", true);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/showRegister");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("result", false);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/showRegister");
                    dispatcher.forward(request, response);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setting(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/userProfile.jsp");
        dispatcher.forward(request, response);
    }
}
