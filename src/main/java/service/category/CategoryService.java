package service.category;

import database.DB;
import entity.Category;
import entity.Product;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryService {
    private static final String GET_CATEGORY_LIST = "SELECT id, name\n" +
            "\tFROM public.category;";
    private static final String GET_ONE_PRODUCT = "SELECT id, titles,  description, sourcelinkto, photofile, created_at,\n" +
            "updated_at FROM public.product where category_id=?";

    public static List<Product> getProductByCategory(int num) {
        List<Product> categoryList = new ArrayList<>();
        try (Connection connection = DB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ONE_PRODUCT);) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, num);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String titles = rs.getString("titles");
                String description = rs.getString("description");
                String sourcelinkTo = rs.getString("sourcelinkto");
                String photofile =new String(Base64.encodeBase64(rs.getBytes("photofile")), "UTF-8");
                Date created_at = rs.getDate("created_at");
                Date updated_at = rs.getDate("updated_at");
                categoryList.add(new Product(id, titles, description, sourcelinkTo, photofile,
                        created_at, updated_at));
            }
        } catch (SQLException | UnsupportedEncodingException exception) {
            DB.printSQLException((SQLException) exception);
        }
        return categoryList;
    }

    public static List<Category> categoryList() {
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = DB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_LIST);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                categoryList.add(new Category(id, name));
            }
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return categoryList;

    }

}
