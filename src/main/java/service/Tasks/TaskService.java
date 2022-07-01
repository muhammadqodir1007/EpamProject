package service.Tasks;

import database.DB;
import entity.TaskBean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskService {

    public int  addTask(TaskBean bean) throws SQLException {

        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into public.work(body,\"createdDate\") values (?,?)");
        preparedStatement.setString(1, bean.getWork());
        Date date = new Date(System.currentTimeMillis());
        preparedStatement.setDate(2, date);
        int i = preparedStatement.executeUpdate();
        return i;

    }

   

}
