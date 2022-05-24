import database.PeopleDb;

import java.sql.SQLException;

public class MAIN {

    public static void main(String[] args) throws SQLException {
        boolean b = PeopleDb.existByEmail("something@gmail.com");
        System.out.println(b);


    }
}
