import beans.PeopleBean;
import database.PeopleDb;

import java.sql.SQLException;
import java.util.List;

public class MAIN {

    public static void main(String[] args) throws SQLException {
        boolean b = PeopleDb.existByEmail("Lee@gmail.com");
      //  System.out.println(b);
        try {
            PeopleBean byEmail = PeopleDb.getByEmail("Lee@gmail.com");
//            System.out.println(byEmail.getName());
//            System.out.println(byEmail.getPassword());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<PeopleBean> all = PeopleDb.getAll();
        PeopleBean peopleBean = all.get(0   );
        System.out.println(peopleBean.getEmail());
        int delete = PeopleDb.delete("Lee@gmail.com");

        System.out.println(delete);
        PeopleBean bean=new PeopleBean();
        peopleBean.setName("AirRack");
        peopleBean.setEmail("something@gmail.com");
        peopleBean.setPassword("789");
        PeopleDb.save(peopleBean);

    }
}
