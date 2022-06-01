import javax.imageio.stream.ImageOutputStream;
import java.io.*;
import java.sql.*;

public class MainTest {

    private static final long serialVersionUID = 1L;
    final static String URL = "jdbc:postgresql://localhost/Epam";
    final static String USER = "postgres";
    final static String PASSWORD = "1007";
    final static String DRIVER = "org.postgresql.Driver";
   static Connection conn = null;


    public static void main(String[] args) throws SQLException {
        byte[] bytes=null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select photo from public.\"Product\" where id=10");

            while (resultSet.next()){
                bytes = resultSet.getBytes(1);

            }
            File file=new File("D:\\img1.jpg");
           OutputStream outputStream=new FileOutputStream(file);
           outputStream.write(bytes);
           outputStream.close();



        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();

        }

    }
}
