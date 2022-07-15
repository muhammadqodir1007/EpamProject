package service.publisher;

import database.DB;
import entity.Publisher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherService {


    public List<Publisher> getAll() throws SQLException {
        Connection connection = DB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select id,\"nameOfCompany\",address,\"phoneNumber\",email,password,\"created_at\",description,username,\"isActive\" from public.publisher");
        List<Publisher> list = new ArrayList<>();
        while (resultSet.next()) {
            Publisher publisher = new Publisher();
            publisher.setId(resultSet.getLong(1));
            publisher.setNameOfCompany(resultSet.getString(2));
            publisher.setAddress(resultSet.getString(3));
            publisher.setPhoneNumber(resultSet.getString(4));
            publisher.setEmail(resultSet.getString(5));
            publisher.setPassword(resultSet.getString(6));
            publisher.setCreated_at(resultSet.getDate(7));
            publisher.setDescription(resultSet.getString(8));
            publisher.setUsername(resultSet.getString(9));
            publisher.setActive(resultSet.getBoolean(10));
            list.add(publisher);


        }
        return list;


    }


    public int deletebyid(int id) throws SQLException {
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from public.publisher where id=?");
        Long a = Long.valueOf(id);
        preparedStatement.setLong(1, a);
        int i = preparedStatement.executeUpdate();
        return i;


    }

    public int addPublisher(Publisher publisher) throws SQLException {

        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into public.publisher(\"nameOfCompany\",address,\"phoneNumber\",email,password,\"created_at\",\"username\",description,\"isActive\") values (?,?,?,?,?,?,?,?,?)");

        preparedStatement.setString(1, publisher.getNameOfCompany());
        preparedStatement.setString(2, publisher.getAddress());
        preparedStatement.setString(3, publisher.getPhoneNumber());
        preparedStatement.setString(4, publisher.getEmail());
        preparedStatement.setString(5, publisher.getPassword());
        preparedStatement.setDate(6, publisher.getCreated_at());
        preparedStatement.setString(7, publisher.getUsername());
        preparedStatement.setString(8, publisher.getDescription());
        preparedStatement.setBoolean(9, publisher.isActive());
        int i = preparedStatement.executeUpdate();
        return i;

    }

    public static Publisher getPublisher(String name) {

        Connection connection = DB.getConnection();
        Publisher publisher = new Publisher();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(" select id,\"nameOfCompany\",address,\"phoneNumber\",email,password,username,\"isBlocked\" from public.publisher where username=?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                publisher.setId(resultSet.getLong(1));
                publisher.setNameOfCompany(resultSet.getString(2));
                publisher.setAddress(resultSet.getString(3));
                publisher.setPhoneNumber(resultSet.getString(4));
                publisher.setEmail(resultSet.getString(5));
                publisher.setPassword(resultSet.getString(6));
                publisher.setUsername(resultSet.getString(7));
                publisher.setBlocked(resultSet.getBoolean(8));

            }


        } catch (SQLException e) {
            return new Publisher( );
        }
        return publisher;


    }

    public static boolean existByName(String name) throws SQLException {

        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select count(*) from public.publisher where username=?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        int anInt = 0;
        while (resultSet.next()) {
            anInt = resultSet.getInt(1);
            System.out.println(anInt);

        }
        return anInt != 0;

    }

    public Publisher getOneById(int id) throws SQLException {
        Connection connection = DB.getConnection();
        Publisher publisher = new Publisher();
        PreparedStatement preparedStatement = connection.prepareStatement("select id,\"nameOfCompany\",address,\"phoneNumber\",email,password,username   from PUBLIC.publisher where id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {

            publisher.setId(resultSet.getLong(1));
            publisher.setNameOfCompany(resultSet.getString(2));
            publisher.setAddress(resultSet.getString(3));
            publisher.setPhoneNumber(resultSet.getString(4));
            publisher.setEmail(resultSet.getString(5));
            publisher.setPassword(resultSet.getString(6));
            publisher.setUsername(resultSet.getString(7));
        }
        return publisher;


    }

    public int BlockId(Long id) throws SQLException {

        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.publisher SET\n" +
                "\"isBlocked\" = true::boolean WHERE\n" +
                "id = ?;");
        preparedStatement.setLong(1, id);
        int i = preparedStatement.executeUpdate();
        return i;


    }


}
