import database.DB;
import entity.PeopleBean;
import entity.ProductBean;
import service.people.PeopleService;
import service.product.ProductServiceImpl;

import javax.imageio.stream.ImageOutputStream;
import java.io.*;
import java.sql.*;
import java.util.List;

public class MainTest {

    public static void main(String[] args) throws SQLException {
PeopleBean bean=new PeopleBean("kd","ds","sds","sds","em");
PeopleService peopleService=new PeopleService();
peopleService.addUser(bean);


    }



}
