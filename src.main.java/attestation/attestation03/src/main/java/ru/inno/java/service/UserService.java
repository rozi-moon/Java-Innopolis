package ru.inno.java.service;

import ru.inno.java.dto.UserRequest;
import ru.inno.java.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse getUser(Long userId);

    List<UserResponse> getUsers();

    UserResponse createUser(UserRequest userRequest);

   UserResponse updateUser(Long userId, UserRequest userRequest);

    void archiveUser(Long userId);

}
