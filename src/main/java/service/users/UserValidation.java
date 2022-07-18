package service.users;

import entity.Publisher;
import entity.Users;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static service.users.UserValidation.ValidResult.*;

public interface UserValidation extends Function<Users, UserValidation.ValidResult> {
    UserService USER_SERVICE = new UserService();

    static UserValidation isUserNameValid() {
        return users ->
        {
            System.out.println("running name validation");
            Predicate<String> predicate = (s) -> s.equals(users.getUsername());
            List<String> nameList = USER_SERVICE.getAllUser().stream().map(s -> s.getUsername()).collect(Collectors.toList());
            boolean status = false;
            for (String nam : nameList) {
                if (predicate.test(nam)) {
                    status = true;
                    break;
                } else {
                    continue;
                }
            }
            return status ? USERNAME_NOT_VALID : SUCCESS;
        };
    }
    static UserValidation isFullNameValid() {
        System.out.println("fullname runing");
        List<String> fulname = USER_SERVICE.getAllUser().
                stream().map(s -> s.getFullName()).
                collect(Collectors.toList());
        return users ->
                fulname.contains(users.getFullName()) ? FULLNAME_NOT_VALID : SUCCESS;
    }

    static UserValidation isPhoneNumberValid() {
        return publisher ->
        {
            List<String> phoneNumber = USER_SERVICE.getAllUser().stream().map(s -> s.getPhoneNumber()).collect(Collectors.toList());
            boolean status = false;
            Predicate<String> stringPredicat = (n) -> n.equals(publisher.getPhoneNumber());
            for (String s : phoneNumber) {
                if (stringPredicat.test(s)) {
                    status = true;
                } else {
                    continue;
                }
            }
            return status ? PHONE_NUMBER_NOT_VALID : SUCCESS;
        };


    }

    static UserValidation isEmailValid() {
        List<String> email = USER_SERVICE.getAllUser().stream().
                map(s -> s.getEmail())
                .collect(Collectors.toList());
        return users ->
                email.contains(users.getEmail()) ? EMAIL_NOT_VALID : SUCCESS;
    }



    default UserValidation and(UserValidation validation) {
        return users ->
        {
            ValidResult validResult = this.apply(users);
            return validResult.equals(SUCCESS) ? validation.apply(users) : validResult;
        };
    }

    enum ValidResult {
        SUCCESS,
        USERNAME_NOT_VALID,
        FULLNAME_NOT_VALID,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID
    }

}
