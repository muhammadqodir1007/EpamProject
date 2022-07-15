package controller;

import database.DB;
import entity.Category;
import entity.ProductBean;
import service.category.CategoryServices;
import service.product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/addNewsByPublisher")

@MultipartConfig
public class addNewsByPublisher extends HttpServlet {

    ProductServiceImpl productService = new ProductServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") == null) {
            resp.sendRedirect("login.jsp");
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title>Add News</title>");
        out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        req.getRequestDispatcher("NavPublisher.html").include(req, resp);
        out.println("<div class='container' style=\"margin-left: 250px\">");

        out.println("<form action=\"/addNewsByPublisher\" , method=\"post\" enctype=\"multipart/form-data\">\n" +
                "\n" +
                "\n" +
                "    <div class=\"form-row\">\n" +
                "        <div class=\"form-group col-md-6\">\n" +
                "            <label for=\"inputEmail4\">Title</label>\n" +
                "            <input type=\"text\" name=\"title\" class=\"form-control\" id=\"inputEmail4\" placeholder=\"Name\">\n" +
                "        </div>\n" +
                "        <div class=\"form-group col-md-6\">\n" +
                "            <label for=\"inputPassword4\">Description</label>\n" +
                "            <input type=\"text\" name=\"description\" class=\"form-control\" id=\"inputPassword4\" placeholder=\"description\">\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"form-group\">\n" +
                "        <label for=\"inputAddress\">Link</label>\n" +
                "        <input type=\"url\" name=\"link\" class=\"form-control\" id=\"inputAddress\" placeholder=\"Link\">\n" +
                "    </div>");

        out.println("    <div class=\"form-group\">\n" +
                "        <label for=\"inputAddress\">CategoryId  : </label>\n" +
                "        <label>\n" +
                "            <select name=\"categoryId\" >\n");
        List<Category> list = null;
        try {
            list = CategoryServices.categoryList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Category category : list) {
            out.println("<option value=" + category.getId() + ">" + category.getName() + "</option>");


        }
        out.println("            </select>\n" +
                "        </label>\n" +
                "    </div>\n");

        out.println("    <div class=\"form-group\">\n" +
                "        <label for=\"inputAddress2\">Photo</label>\n" +
                "        <input type=\"file\" class=\"form-control\" id=\"inputAddress2\" name=\"photo\" placeholder=\"photo\">\n" +
                "    </div>\n" +
                "    <div class=\"form-group\">\n" +
                "        <label for=\"inputAddress2\">Text</label>\n" +
                "        <input type=\"text\" class=\"form-control\" id=\"inputAddress3\" name=\"text\" placeholder=\"text\">\n" +
                "    </div>\n" +
//                    "<div class=\"form-group\">\n" +
//                    "        <label for=\"inputAddress2\">Text</label>\n" +
//                    "        <input type=\"number\" class=\"form-control\" id=\"inputAddress3\" name=\"publisherId\" placeholder=\"publisherId\">\n" +
//                    "    </div>\n" +
                "\n" +
                "\n" +
                "    <button type=\"submit\" class=\"btn btn-primary\">Add</button>\n" +
                "\n" +
                "    <a href=\"Home.jsp\">Back to Home</a>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "</form>");


        out.println("</div>");
        out.println("</body>");
        out.println("</html>");


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String link = req.getParameter("link");
        Part photo = req.getPart("photo");
        String categoryId = req.getParameter("categoryId");
        Long publisherId = Login.publisher.getId();
        Date date = new Date(System.currentTimeMillis());

        int integer = Integer.parseInt(categoryId);
        System.out.println(integer);
        Connection connection = DB.getConnection();
        System.out.println(connection);

        String text = req.getParameter("text");
        ProductBean productBean = new ProductBean();
        productBean.setTitles(title);
        productBean.setDescription(description);
        productBean.setSourceLinkTo(link);
        productBean.setPhotoFile(photo.getInputStream().readAllBytes());
        productBean.setCreatedTime(date);
        productBean.setText(text);
        productBean.setPublisher_id(Math.toIntExact(publisherId));

        productBean.setCategory_Id(integer);
        System.out.println(productBean.getTitles());
        System.out.println(productBean.getCategory_Id());
        System.out.println(productBean.getPublisher_id());

        try {
            int i = productService.addNews(productBean);
            if (i != 0) {
                resp.sendRedirect("/viewNewsByPublisher");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}