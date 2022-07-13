package service.category;


import database.DB;
import entity.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryServices {


    public static List<Category> categoryList() throws SQLException {
        Connection connection = DB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from PUBLIC.category");
        List<Category> list = new ArrayList<>();

        while (resultSet.next()) {
            Category category = new Category();
            category.setId(resultSet.getLong(1));
            category.setName(resultSet.getString(2));
            list.add(category);


        }

        return list;
    }

    public static Category getOne(int id) throws SQLException {
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from PUBLIC.category where id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Category category = null;
        while (resultSet.next()) {
           category = new Category();
            category.setId(resultSet.getLong(1));
            category.setName(resultSet.getString(2));
        }

        return category;


    }


}
