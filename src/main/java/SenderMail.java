import entity.Users;
import payload.CookieService;
import payload.UserDto;
import service.product.ProductServiceImpl;
import service.users.UserService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

public class SenderMail {

    public static void main(String[] args) throws ParseException {
        UserService userService = new UserService();
        Users users = new Users("boxobek", "Boxodir jorayev", "1", "994612309", "boxo@mail.ru");
        System.out.println(userService.saveUser(users));
    }
}
