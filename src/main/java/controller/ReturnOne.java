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

@WebServlet("/returnOne")
public class ReturnOne extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username")==null){
            resp.sendRedirect("login.jsp");
        }
        if (req.getSession().getAttribute("username")==null){
            resp.sendRedirect("login.jsp");
        }
        PrintWriter out = resp.getWriter();
        try {

            ProductBean id = productService.getOne(Integer.parseInt(req.getParameter("id")));
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
        String category="";

            switch (id.getCategory_Id()){
                case 1:
                    category="General";
                case 2:
                    category="Politics";
                case 3:
                    category="Sport";

            }
            out.println("<tr><td>"+id.getTitles()+"</td><td>"+id.getDescription()+"</td><td>"+id.getSourceLinkTo()+"</td><td>"+id.getCreatedTime()+"</td><td>"+category+"</td></tr>");





        } catch (SQLException e) {
            e.printStackTrace();
        }}
    }
