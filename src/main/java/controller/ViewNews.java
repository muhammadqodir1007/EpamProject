package controller;

import entity.ProductBean;
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

@WebServlet("/viewNews")
public class ViewNews extends HttpServlet {
//    ProductServiceImpl productService = new ProductServiceImpl();
//
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//
//        try {
//            List<ProductBean> all = productService.getAll();
//            out.print("<!DOCTYPE html>");
//            out.print("<html>");
//            out.println("<head>");
//            out.println("<title>View News</title>");
//            out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>");
//            out.println("</head>");
//            out.println("<body>");
//           // req.getRequestDispatcher("NavAdmin.html").include(req,resp);
//
//            out.println("<div class='container' style='margin-left: 250px  >");
//
//            out.println("<table class='table table-bordered table-striped'>");
//            out.println("<tr><th>title</th><th>description</th><th>link</th><th>time</th><th>category</th></tr>");
////            boolean empty = all.isEmpty();
////            out.println(empty);
//
//            for (ProductBean productBean : all) {
//                String category="";
//                switch (productBean.getCategoryId()){
//                    case 1:
//                        category="General";
//                    case 2 :
//                        category="Politics";
//                    case 3:
//                        category="Sport";
//
//                }
//               out.println("<tr><td>" + productBean.getTitles() + "</td><td>" + productBean.getDescription() + "</td><td>" + productBean.getSourceLinkTo() + "</td><td>"+productBean.getCreatedTime()+"</td><td>"+category+"</td><td><a href='deleteNews?id=" + productBean.getId() + "'>Delete</a></td></tr>");
//
//            }
//            out.println("</table>");
//            out.println("</div>");
//            out.println("</body>");
//            out.println("</html>");
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
   // }
ProductServiceImpl productService = new ProductServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            List<ProductBean> all = productService.getAll();
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.println("<head>");
            out.println("<title>View News</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            req.getRequestDispatcher("NavAdmin.html").include(req,resp);
            out.println("<div class='container' style=\"margin-left: 250px\">");
                out.println("<table class='table table-bordered table-striped'>");
            out.println("<tr><th>title</th><th>description</th><th>link</th><th>time</th><th>category</th></tr>");


            for (ProductBean productBean : all) {
                String category="";
                switch (productBean.getCategoryId()){
                    case 1:
                        category="Sport";
                    case 2:
                        category="Politics";
                    case 3 :
                        category="Generel";
                }
            out.println("<tr><td>" + productBean.getTitles() + "</td><td>" + productBean.getDescription() + "</td><td>" + productBean.getSourceLinkTo() + "</td><td>"+productBean.getCreatedTime()+"</td><td>"+category+"</td><td><a href='deleteNews?id=" + productBean.getId() + "'>Delete</a></td></tr>");

//
//
            }
            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");


        } catch (SQLException e) {
            e.printStackTrace();
        }}}








