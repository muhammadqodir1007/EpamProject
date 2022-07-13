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
        ResultSet resultSet = statement.executeQuery("select * from public.publisher");
        List<Publisher> list = new ArrayList<>();
        while (resultSet.next()) {
            Long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String phoneNumber = resultSet.getString(4);
            String email = resultSet.getString(5);
            String password = resultSet.getString(6);
            Date created_at = resultSet.getDate(7);
            Date updated_at = resultSet.getDate(8);
            Publisher publisher = new Publisher(id, name, address, phoneNumber, email, password, created_at, updated_at);

            list.add(publisher);
        }
        return list;


    }


    public int deletebyid(int id) throws SQLException {
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from public.publisher where id=?");
        Long a= Long.valueOf(id);
        preparedStatement.setLong(1,a);
        int i = preparedStatement.executeUpdate();
        return i;


    }

    public int addPublisher(Publisher publisher) throws SQLException {

        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into public.publisher(\"nameOf\",address,\"phoneNumber\",email,password,\"created_at\") values (?,?,?,?,?,?)");
        preparedStatement.setString(1, publisher.getName());
        preparedStatement.setString(2, publisher.getAddress());
        preparedStatement.setString(3, publisher.getPhoneNumber());
        preparedStatement.setString(4, publisher.getEmail());
        preparedStatement.setString(5, publisher.getPassword());
        preparedStatement.setDate(6, publisher.getCreated_at());
        int i = preparedStatement.executeUpdate();
        return i;

    }

    public static Publisher getPublisher(String name) {

        Connection connection = DB.getConnection();
        Publisher publisher = new Publisher();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(" select \"nameOf\",address,\"phoneNumber\",email,password from public.publisher where \"nameOf\"=?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                publisher.setName(resultSet.getString(1));
                publisher.setAddress(resultSet.getString(2));
                publisher.setPhoneNumber(resultSet.getString(3));
                publisher.setEmail(resultSet.getString(4));
                publisher.setPassword(resultSet.getString(5));
            }



        } catch (SQLException e) {
            return new Publisher("","","","","");
        }
        return publisher;


    }


}
