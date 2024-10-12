package ru.inno.java.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.java.dto.UserRequest;
import ru.inno.java.dto.UserResponse;
import ru.inno.java.entity.Card;
import ru.inno.java.entity.User;
import ru.inno.java.repository.CardRepository;
import ru.inno.java.repository.UserRepository;
import ru.inno.java.service.UserService;
import ru.inno.java.utils.UserUtils;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CardRepository cardRepository;

    @Override
    public UserResponse getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        List<Card> cards = cardRepository.findAllByUserId(userId);
        return UserUtils.convertToUserResponse(user, cards);
    }

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAllActive();
        return users.stream()
                .map(UserUtils::convertToUserResponse)
                .toList();
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = UserUtils.convertToUser(userRequest);
        User savedUser = userRepository.saveAndFlush(user);
        return UserUtils.convertToUserResponse(savedUser);
    }

    @Override
    public UserResponse updateUser(Long userId, UserRequest userRequest) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        UserUtils.updateUser(user, userRequest);
        User savedUser = userRepository.saveAndFlush(user);
        return UserUtils.convertToUserResponse(savedUser);
    }

    @Override
    public void archiveUser(Long userId) {
        userRepository.softDelete(userId);
    }
}
