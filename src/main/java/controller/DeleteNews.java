package controller;

import service.product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteNews")
public class DeleteNews extends HttpServlet {
    ProductServiceImpl productService=new ProductServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            productService.delete(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("viewNews");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
