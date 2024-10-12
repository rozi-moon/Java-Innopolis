package utils;

import ru.inno.java.dto.UserRequest;
import ru.inno.java.entity.User;

import java.time.LocalDate;

public class UserBuilder {

    public static User getUser() {
        return User.builder()
                .id(1L)
                .name("name")
                .phoneNumber("1234567890")
                .email("email@email.com")
                .birthday(LocalDate.of(1993, 10, 10))
                .password("password")
                .deleted(false)
                .build();
    }

    public static UserRequest getUserRequest() {
        return UserRequest.builder()
                .name("new_name")
                .email("new_email@email.com")
                .birthday(null)
                .password("new_password")
                .build();
    }
}
