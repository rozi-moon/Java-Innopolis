import attestation.attestation01.exception.UserNotFoundException;
import attestation.attestation01.model.User;
import attestation.attestation01.repository.UserRepository;
import attestation.attestation01.repository.impl.UsersRepositoryFileImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class UserRepositoryFileImplTest {

    private static final UserRepository userRepository = new UsersRepositoryFileImpl();

    @Test
    void createUser() {
        User user = new User(UUID.randomUUID().toString(), "login", "p", "p", "fi", "na", "ot", 10, false);
        userRepository.create(user);
        User savedUser = userRepository.findById(user.getId());
        Assertions.assertNotNull(savedUser);
        Assertions.assertEquals(user.getLogin(), savedUser.getLogin());
    }

    @Test
    void updateUser() {
        User user = new User(UUID.randomUUID().toString(), "login", "p", "p", "fi", "na", "ot", 10, false);
        userRepository.create(user);
        user.setName("name");
        userRepository.update(user);
        User updatedUser = userRepository.findById(user.getId());
        Assertions.assertEquals("name", updatedUser.getName());
    }

    @Test
    void findUserByIdWithError() {
        Assertions.assertThrows(UserNotFoundException.class, () -> userRepository.findById(UUID.randomUUID().toString()));
    }

    @Test
    void deleteUserByIdWithError() {
        Assertions.assertThrows(UserNotFoundException.class, () -> userRepository.deleteById(UUID.randomUUID().toString()));
    }

}
