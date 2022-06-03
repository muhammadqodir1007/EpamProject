package controller;

import entity.ProductBean;
import service.product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/addNews")
@MultipartConfig
public class AddNews extends HttpServlet {

    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("addNews.html");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        Part photo = req.getPart("photo");
        Date date = new Date(System.currentTimeMillis());
        ProductBean bean = new ProductBean(name, title, description, date, photo.getInputStream().readAllBytes());
        try {
            int i = productService.addNews(bean);
            if (i != 0) {
                resp.sendRedirect("addNews");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
