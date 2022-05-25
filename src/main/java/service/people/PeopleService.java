package service.people;

import entity.PeopleBean;

import java.sql.SQLException;
import java.util.List;

public interface PeopleService {
    int save(PeopleBean peopleBean);
    Boolean existByEmail(String emailName) throws SQLException;
    PeopleBean getByEmail(String email) throws SQLException;
    List<PeopleBean> getAll() throws SQLException;
    void delete(String email) throws SQLException;

}
