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
            PreparedStatement preparedStatement = connection.prepareStatement("insert into public.\"product\"(titles,description,\"sourcelinkTo\", \"createdTime\",category_id,photofile,text) values (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, productBean.getTitles());
            preparedStatement.setString(2, productBean.getDescription());
            preparedStatement.setString(3, productBean.getSourceLinkTo());
            preparedStatement.setDate(4, productBean.getCreatedTime());
            preparedStatement.setInt(5, productBean.getCategoryId());
            preparedStatement.setBytes(6, productBean.getPhotoFile());
            preparedStatement.setString(7, productBean.getText());
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
            ResultSet resultSet = statement.executeQuery("select * from public.\"product\"  ");
            while (resultSet.next()) {
                ProductBean productBean = new ProductBean();
                productBean.setId(resultSet.getInt(1));
                productBean.setTitles(resultSet.getString(2));
                productBean.setDescription(resultSet.getString(3));
                productBean.setSourceLinkTo(resultSet.getString(4));
                productBean.setCreatedTime(resultSet.getDate(5));
                productBean.setCategoryId(resultSet.getInt(6));
                productBean.setPhotoFile(resultSet.getBytes(7));
                productBean.setText(resultSet.getString(8));
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

            PreparedStatement preparedStatement = connection.prepareStatement("select * from public.\"product\" where id=? ");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productBean.setId(resultSet.getInt(1));
                productBean.setTitles(resultSet.getString(2));
                productBean.setDescription(resultSet.getString(3));
                productBean.setSourceLinkTo(resultSet.getString(4));
                productBean.setCreatedTime(resultSet.getDate(5));
                productBean.setCategoryId(resultSet.getInt(6));
                productBean.setPhotoFile(resultSet.getBytes(7));
                productBean.setText(resultSet.getString(8));

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
        PreparedStatement preparedStatement = connection.prepareStatement("delete from public.\"product\" where id=?");
        preparedStatement.setInt(1, id);
        int i = preparedStatement.executeUpdate();
        return i;


    }

    @Override
    public int edit(int id) {


        return 0;

    }
}
