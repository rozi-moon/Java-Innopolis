package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.inno.java.dto.UserRequest;
import ru.inno.java.dto.UserResponse;
import ru.inno.java.entity.Card;
import ru.inno.java.entity.User;
import ru.inno.java.repository.CardRepository;
import ru.inno.java.repository.UserRepository;
import ru.inno.java.service.UserService;
import ru.inno.java.service.impl.UserServiceImpl;
import ru.inno.java.utils.UserUtils;
import utils.CardBuilder;
import utils.UserBuilder;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootTest(classes = UserServiceImpl.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private CardRepository cardRepository;

    @Test
    void getUser() {
        Long userId = 1L;
        User user = UserBuilder.getUser();
        List<Card> cards = List.of(CardBuilder.getCard(user));

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        Mockito.when(cardRepository.findAllByUserId(userId)).thenReturn(cards);

        UserResponse userResponse = userService.getUser(userId);

        Assertions.assertNotNull(userResponse.getId());
    }

    @Test
    void getUserWithError() {
        Long userId = 1L;
        Mockito.when(userRepository.findById(userId)).thenThrow(new NoSuchElementException());
        Assertions.assertThrows(NoSuchElementException.class,() -> userService.getUser(userId));
    }

    @Test
    void getUsers() {
        List<User> users = List.of(UserBuilder.getUser());

        Mockito.when(userRepository.findAllActive()).thenReturn(users);

        List<UserResponse> userResponses = userService.getUsers();
        Assertions.assertNotNull(userResponses);
        Assertions.assertEquals(users.size(),userResponses.size());
    }

    @Test
    void updateUser() {
        Long userId = 1L;
        UserRequest request = UserBuilder.getUserRequest();
        User user = UserBuilder.getUser();

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.saveAndFlush(user)).thenReturn(user);

        UserResponse userResponse = userService.updateUser(userId, request);
        Assertions.assertNotNull(userResponse.getId());
        Assertions.assertEquals(userResponse.getId(), userId);
    }

    @Test
    void archiveUser() {
        Long userId = 1L;

        Assertions.assertDoesNotThrow(() -> userService.archiveUser(userId));
    }


}
