package controller;

import entity.Category;
import entity.Product;

import payload.ProductResponse;
import service.category.CategoryService;
import service.product.ProductService;
import service.product.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/", "/categoryNews", "/singleData"})
@MultipartConfig(maxFileSize = 16177215)
public class ProductController extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private ProductService productService;

    public void init()
    {
        productService = new ProductServiceImpl();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/categoryNews":
                    listOfCategory(request, response);
                    break;
                case "/singleData":
                    getOnlyOneData(request, response);
                    break;
                case "/searchNews":
                    getFilteredNews(request, response);
                    break;
                default:
                    newsList(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void newsList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<ProductResponse> productList = productService.getAllProduct();
        Product product = productService.getOneProduct();
        request.setAttribute("latestProduct", product);
        commonItems(request, response);
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }

    public void getOnlyOneData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProductByID(id);
        request.setAttribute("currentProduct", product);
        commonItems(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-to-do/singlePage.jsp");
        dispatcher.forward(request, response);
    }

    protected void getFilteredNews(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String title = request.getParameter("searchedProduct");
        String categoryId = request.getParameter("category_id");
        commonItems(request, response);
        if (categoryId.equals("Categories")) {
            //go filter only titles
            List<Product> productByTitles = productService.getProductByTitles(title);
            if (!productByTitles.isEmpty()) {
                request.setAttribute("searchedProduct", productByTitles);
                RequestDispatcher dispatcher = request.getRequestDispatcher("list-to-do/searchList.jsp");
                dispatcher.forward(request, response);

            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("notFoundMessages/noFound.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            //only category and title
            int cat_Id = Integer.parseInt(request.getParameter("category_id"));
            List<Product> productByTitleandCategory = productService.getProductByTitleandCategory(title, cat_Id);
            if (!productByTitleandCategory.isEmpty()) {
                request.setAttribute("searchedProduct", productByTitleandCategory);
                RequestDispatcher dispatcher = request.getRequestDispatcher("list-to-do/searchList.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("notFoundMessages/noFound.jsp");
                dispatcher.forward(request, response);
            }
        }


    }

    public void listOfCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> list = CategoryService.getProductByCategory(id);
        request.setAttribute("productCategory", list);
        commonItems(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-to-do/list-category.jsp");
        dispatcher.forward(request, response);
    }

    public void commonItems(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> stringListOfLastPost = productService.showLastsixProduct();
        request.setAttribute("lastPosts", stringListOfLastPost);
        List<Category> categoryList = CategoryService.categoryList();
        request.setAttribute("categoryList", categoryList);
    }


}
