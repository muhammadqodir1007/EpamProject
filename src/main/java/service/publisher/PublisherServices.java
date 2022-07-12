package service.publisher;

import database.DB;
import entity.Publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherServices {
    private static final String GET_PUBLISHER_BY_PRODUCT_ID = "SELECT publisher.id, " +
            "nameof, address, publisher.description, phonenumber, email, password\n" +
            "\tFROM public.publisher inner join product on" +
            " product.publisher_id=publisher.id where product.id=?";
    private static final String GET_PUBLISHER_BY_ID = "SELECT id, nameof, address, description, phonenumber, email, password, created_at, updated_at\n" +
            "\tFROM public.publisher where id=?";

    public ResultSet getresultSet(String query) throws SQLException {
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        return rs;
    }

    public PreparedStatement getstatement(String query) throws SQLException {
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement;
    }


    public Publisher getPublisherByProductId(long num) {
        Publisher publishers = new Publisher();
        try (PreparedStatement preparedStatement = getstatement(GET_PUBLISHER_BY_PRODUCT_ID)) {
            preparedStatement.setLong(1, num);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                publishers.setId(resultSet.getLong("id"));
                publishers.setNameOf(resultSet.getString("nameOf"));
                publishers.setAddress(resultSet.getString("address"));
                publishers.setPhoneNumber(resultSet.getString("phoneNumber"));
                publishers.setDescription(resultSet.getString("description"));
                publishers.setEmail(resultSet.getString("email"));
                publishers.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return publishers;

    }

    public Publisher getPublisherById(long id) {
        Publisher publishersPublisher = new Publisher();
        try (PreparedStatement preparedStatement = getstatement(GET_PUBLISHER_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                publishersPublisher.setNameOf(resultSet.getString("nameOf"));
                publishersPublisher.setAddress(resultSet.getString("address"));
                publishersPublisher.setPhoneNumber(resultSet.getString("phoneNumber"));
                publishersPublisher.setDescription(resultSet.getString("description"));
                publishersPublisher.setEmail(resultSet.getString("email"));
                publishersPublisher.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return publishersPublisher;
    }
}
