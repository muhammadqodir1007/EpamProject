import database.DB;
import entity.ProductBean;
import service.product.ProductServiceImpl;

import javax.imageio.stream.ImageOutputStream;
import java.io.*;
import java.sql.*;
import java.util.List;

public class MainTest {

    public static void main(String[] args) throws SQLException {
        Connection connection = DB.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("CREATE OR REPLACE FUNCTION trigger_set_timestamp()\n" +
                "RETURNS TRIGGER AS $$\n" +
                "BEGIN\n" +
                "  NEW.updated_at = NOW();\n" +
                "  RETURN NEW;\n" +
                "END;\n" +
                "$$ LANGUAGE plpgsql;\n" +
                "\n" +
                "CREATE TRIGGER set_timestamp\n" +
                "BEFORE UPDATE ON users\n" +
                "FOR EACH ROW\n" +
                "EXECUTE PROCEDURE trigger_set_timestamp();");



    }


}
