package database;

import beans.PeopleBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeopleDb {

    public static int save(PeopleBean bean) {

        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        int res = 0;
        try {
            preparedStatement = connection.prepareStatement("insert into people(name,email,password) values (?,?,?)");
            preparedStatement.setString(1, bean.getName());
            preparedStatement.setString(2, bean.getEmail());
            preparedStatement.setString(3, bean.getPassword());
            res = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;

    }

    public static boolean existByEmail(String email) throws SQLException {
        Connection connection = DB.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select name from people where email=?");
            ps.setString(1, email);
            //     int i = ps.executeUpdate();
            ResultSet resultSet = ps.executeQuery();

            return resultSet.next();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return false;


    }

    public static PeopleBean getByEmail(String email) throws SQLException {
        PeopleBean peopleBean = new PeopleBean();
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from people where email=?");
        preparedStatement.setString(1, email);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            peopleBean.setId(rs.getInt(1));
            peopleBean.setName(rs.getString(2));
            peopleBean.setEmail(rs.getString(3));
            peopleBean.setPassword(rs.getString(4));

        }

        connection.close();
        return peopleBean;

    }

    public static List<PeopleBean> getAll() throws SQLException {
        List<PeopleBean> list = new ArrayList<>();
        Connection connection = DB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from people");

        while (resultSet.next()) {
            PeopleBean peopleBean = new PeopleBean();
            peopleBean.setId(resultSet.getInt(1));
            peopleBean.setName(resultSet.getString(2));
            peopleBean.setEmail(resultSet.getString(3));
            peopleBean.setPassword(resultSet.getString(4));
            list.add(peopleBean);


        }
        connection.close();
        return list;


    }

    public static int delete(String email) throws SQLException {
        int res = 0;
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from people where email=?");
        preparedStatement.setString(1,email);
        int i = preparedStatement.executeUpdate();
        return i;
    }


}
