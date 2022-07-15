package service.complain;

import database.DB;
import entity.Complain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComplainService {


    public List<Complain> getAll() throws SQLException {

        Connection connection = DB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from PUBLIC.complain");
        List<Complain> list = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String message = resultSet.getString(2);
            int user_id = resultSet.getInt(3);
            int publisher_id = resultSet.getInt(4);
            Complain complain = new Complain();
            complain.setId(id);
            complain.setMessage(message);
            complain.setUser_id(user_id);
            complain.setPublisher_id(publisher_id);
            list.add(complain);


        }
        return list;


    }




}
