import entity.Users;
import payload.UserDto;
import service.product.ProductService;
import service.product.ProductServiceImpl;
import service.users.UserService;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainTest {

    public static void main(String[] args) throws SQLException {
        ProductServiceImpl userService= new ProductServiceImpl();
        System.out.println(userService.getOneProduct());
//        boolean status=false;
//        UserService userService = new UserService();
//        UserDto userDto = new UserDto("Temurbek", "111111");
//        Users users = userService.getUserDetails(userDto);
//        System.out.println(userService.isUserExist(users));
//        System.out.println("SimpleEmail Start");
//        String smtpHostServer = "smtp.email.ru  ";
//        String toEmail = "temurbek.zaripov140996@mail.ru";
//        Properties props = System.getProperties();
//        props.put("mail.smtp.host", smtpHostServer);
//        props.put("mail.smtp.starttls.enable", true);
//        props.put("mail.smtp.port", "25");
//        Session session = Session.getDefaultInstance(props);
//        try {
//            MimeMessage msg = new MimeMessage(session);
//            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//            msg.addHeader("format", "flowed");
//            msg.addHeader("Content-Transfer-Encoding", "8bit");
//            msg.setFrom(new InternetAddress("temurbek.zaripov14091996@mail.ru", "NoReply-JD"));
//            msg.setReplyTo(InternetAddress.parse("temurbek.zaripov14091996@mail.ru", false));
//            msg.setSubject("SimpleEmail Testing Subject", "UTF-8");
//            msg.setText("SimpleEmail Testing Body", "UTF-8");
//            msg.setSentDate(new Date());
//            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//            System.out.println("Message is ready");
//            Transport.send(msg);
//            System.out.println("EMail Sent Successfully!!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
