package service.people;

import database.DB;
import entity.PeopleBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeopleService {

    public  int addUser(PeopleBean bean) {
        int i = 0;
        Connection connection = DB.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO public.users (\n" +
                    "username, \"fullName\", password, \"phoneNumber\", email) values (?,?,?,?,?)");
            ps.setString(1, bean.getUsername());
            ps.setString(2, bean.getFullName());
            ps.setString(3, bean.getPassword());
            ps.setString(4, bean.getPhoneNumber());
            ps.setString(5, bean.getEmail());

            i = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;

    }

    public List<PeopleBean> getAll() throws SQLException {

        Connection connection = DB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from PUBLIC.users ");
        List<PeopleBean> list = new ArrayList<>();
        while (resultSet.next()) {
            PeopleBean bean = new PeopleBean();
            bean.setId(resultSet.getInt(1));
            bean.setUsername(resultSet.getString(2));
            bean.setFullName(resultSet.getString(3));
            bean.setPassword(resultSet.getString(4));
            bean.setPhoneNumber(resultSet.getString(5));
            bean.setEmail(resultSet.getString(6));
            bean.setCreatedAt(resultSet.getDate(7));
            list.add(bean);

        }
        return  list;


    }
    public int deleteById(int id) throws SQLException {
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from public.users where id=?");
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate();



    }


}