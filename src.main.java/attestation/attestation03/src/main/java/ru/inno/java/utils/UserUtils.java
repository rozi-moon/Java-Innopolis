package ru.inno.java.utils;

import ru.inno.java.dto.UserRequest;
import ru.inno.java.dto.UserResponse;
import ru.inno.java.entity.Card;
import ru.inno.java.entity.User;

import java.util.List;
import java.util.Optional;

public class UserUtils {

    public static UserResponse convertToUserResponse(User user, List<Card> cards) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .birthday(user.getBirthday())
                .phone(user.getPhoneNumber())
                .cards(cards.stream()
                        .map(CardUtils::convertCardToCardResponse)
                        .toList())
                .build();
    }

    public static UserResponse convertToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .birthday(user.getBirthday())
                .phone(user.getPhoneNumber())
                .build();
    }

    public static User convertToUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .birthday(userRequest.getBirthday())
                .password(userRequest.getPassword())
                .phoneNumber(userRequest.getPhone())
                .deleted(false)
                .build();
    }

    public static void updateUser(User user, UserRequest userRequest) {
        user.setName(Optional.ofNullable(userRequest.getName()).orElse(user.getName()));
        user.setEmail(Optional.ofNullable(userRequest.getEmail()).orElse(user.getEmail()));
        user.setPhoneNumber(Optional.ofNullable(userRequest.getPhone()).orElse(user.getPhoneNumber()));
        user.setPassword(Optional.ofNullable(userRequest.getPassword()).orElse(user.getPassword()));
        user.setBirthday(Optional.ofNullable(userRequest.getBirthday()).orElse(user.getBirthday()));
    }

}
