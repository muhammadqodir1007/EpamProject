import database.DB;
import entity.Category;
import entity.PeopleBean;
import entity.ProductBean;
import entity.Publisher;
import service.category.CategoryServices;
import service.people.PeopleService;
import service.product.ProductServiceImpl;
import service.publisher.PublisherService;

import javax.imageio.stream.ImageOutputStream;
import java.io.*;
import java.sql.*;
import java.util.List;

public class MainTest {

    public static void main(String[] args) throws SQLException {


        PublisherService publisherService=new PublisherService();
        List<Publisher> all = publisherService.getAll();
        for (Publisher publisher : all) {
            System.out.println(publisher.getUsername());
        }

    }



}
