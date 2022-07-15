package controller;

import entity.Category;
import entity.ProductBean;
import service.category.CategoryServices;
import service.product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/viewNewsByPublisher")
public class viewNewsByPublisher extends HttpServlet {

    ProductServiceImpl productService = new ProductServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username")==null){
            resp.sendRedirect("login.jsp");
        }
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            List<ProductBean> all = productService.getByUserName(Math.toIntExact(Login.publisher.getId()));
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.println("<head>");
            out.println("<title>View News</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            req.getRequestDispatcher("NavPublisher.html").include(req,resp);
            out.println("<div class='container' style=\"margin-left: 250px\">");
            out.println("<table class='table table-bordered table-striped'>");
            out.println("<tr><th>title</th><th>description</th><th>link</th><th>time</th><th>category</th></tr>");


            for (ProductBean productBean : all) {
                Category one = CategoryServices.getOne(productBean.getCategory_Id());
                String name = one.getName();


                out.println("<tr><td>" + productBean.getTitles() + "</td><td>" + productBean.getDescription() + "</td><td>" + productBean.getSourceLinkTo() + "</td><td>"+productBean.getCreatedTime()+"</td><td>"+name+"</td><td><a href='deleteNewsByPublisher?id=" + productBean.getId() + "'>Delete</a></td></tr>");

//
//
            }
            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");


        } catch (SQLException e) {
            e.printStackTrace();
        }}





}
