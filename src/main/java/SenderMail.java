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
        ProductServiceImpl productService=new ProductServiceImpl();
        DateFormat dateFormat= new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.a");
        String time=dateFormat.format(productService.getProductByID(15).getCreated_at());
//        SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.a");
        Date date=dateFormat.parse(time);
        System.out.println(date);
////        Date date=productService.getProductByID(15).getCreated_at();
////        Date date1=dateFormat.parse(time);
////        System.out.println(date1);
        System.out.println(time);
        System.out.println(productService.getProductByID(15).getCreated_at());
//        Date date = Calendar.getInstance().getTime();
//        String strDate = dateFormat.format(date);
//        System.out.println("Converted String: " + strDate);


//        System.out.println(time);
//        DateFormat.getDateInstance().format(productService.getProductByID(15).getCreated_at());
//        System.out.println(productService.getProductByID(15).getCreated_at());
    }
}
