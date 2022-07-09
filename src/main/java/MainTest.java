import entity.Users;
import payload.UserDto;
import service.product.ProductService;
import service.product.ProductServiceImpl;
import service.users.UserService;

import java.sql.SQLException;

public class MainTest {

    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        UserDto userDto= new UserDto("Zarifov","222222");
        System.out.println(userService.validate(userDto));
    }
}
