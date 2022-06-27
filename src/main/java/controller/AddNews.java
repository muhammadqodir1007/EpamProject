package controller;

import database.DB;
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
import java.sql.Connection;
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
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String link = req.getParameter("link");
        Part photo = req.getPart("photo");
        String categoryId = req.getParameter("categoryId");
        System.out.println(categoryId);
        Date date = new Date(System.currentTimeMillis());

        int integer= Integer.parseInt(categoryId);
        System.out.println(integer);
        Connection connection = DB.getConnection();
        System.out.println(connection);

        String text = req.getParameter("text");
        ProductBean productBean=new ProductBean();
        productBean.setTitles(title);
        productBean.setDescription(description);
        productBean.setSourceLinkTo(link);
        productBean.setPhotoFile(photo.getInputStream().readAllBytes());
        productBean.setCreatedTime(date);
        productBean.setText(text);

        productBean.setCategoryId(integer);
        System.out.println(productBean.getTitles());
        System.out.println(productBean.getCategoryId());


        try {
            int i = productService.addNews(productBean);
            if (i!=0){
                resp.sendRedirect("/viewNews");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
}
