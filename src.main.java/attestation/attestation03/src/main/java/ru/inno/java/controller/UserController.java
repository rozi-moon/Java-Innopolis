package ru.inno.java.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.inno.java.dto.UserRequest;
import ru.inno.java.dto.UserResponse;
import ru.inno.java.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@OpenAPIDefinition
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(description = "Получение пользователя по идентификатору")
    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable("id") Long userId) {
        return userService.getUser(userId);
    }

    @Operation(description = "Получение списка пользователей")
    @GetMapping
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @Operation(description = "Создание пользователя")
    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @Operation(description = "Обновление данных пользователя")
    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable("id") Long userId, @RequestBody UserRequest userRequest) {
        return userService.updateUser(userId, userRequest);
    }

    @Operation(description = "Архивирование пользователя")
    @DeleteMapping("/{id}")
    public void archiveUser(@PathVariable("id") Long userId) {
        userService.archiveUser(userId);
    }

}
