package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    public static Connection getConnection() {

        Connection connection=null;
        try {
            connection=DriverManager.getConnection("jdbc:postgresql://localhost/Epam","postgres","1007");        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
