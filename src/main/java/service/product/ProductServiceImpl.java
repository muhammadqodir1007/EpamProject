package service.product;

import database.DB;
import entity.ProductBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public int addNews(ProductBean productBean) throws SQLException {
        Connection connection = DB.getConnection();
        int i = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into public.\"Product\"(name,title,description,\"createdDate\",photo) values (?,?,?,?,?)");
            preparedStatement.setString(1, productBean.getName());
            preparedStatement.setString(2, productBean.getTitle());
            preparedStatement.setString(3, productBean.getDescription());
            preparedStatement.setDate(4, productBean.getCreatedDate());
            preparedStatement.setBytes(5, productBean.getPhoto());
            i = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public List<ProductBean> getAll() throws SQLException {
        Connection connection = DB.getConnection();
        List<ProductBean> list = null;
        try {
            list = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from public.\"Product\"");
            while (resultSet.next()) {
                ProductBean productBean = new ProductBean();
                productBean.setId(resultSet.getInt(1));
                productBean.setName(resultSet.getString(2));
                productBean.setTitle(resultSet.getString(3));
                productBean.setDescription(resultSet.getString(4));
                productBean.setCreatedDate(resultSet.getDate(5));
                productBean.setPhoto(resultSet.getBytes(6));
                list.add(productBean);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return list;

    }

    @Override
    public ProductBean getOne(int id) throws SQLException {
        Connection connection = DB.getConnection();
        ProductBean productBean = new ProductBean();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from public.\"Product\" where id=? ");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productBean.setId(resultSet.getInt(1));
                productBean.setName(resultSet.getString(2));
                productBean.setTitle(resultSet.getString(3));
                productBean.setDescription(resultSet.getString(4));
                productBean.setCreatedDate(resultSet.getDate(5));
                productBean.setPhoto(resultSet.getBytes(6));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return productBean;


    }


    @Override
    public int delete(int id) throws SQLException {
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from public.\"Product\" where id=?");
        preparedStatement.setInt(1, id);
        int i = preparedStatement.executeUpdate();
        return i;


    }

    @Override
    public int edit(int id) {


        return 0;

    }
}
