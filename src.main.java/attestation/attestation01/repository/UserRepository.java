package attestation.attestation01.repository;

import attestation.attestation01.model.User;

import java.io.FileNotFoundException;
import java.util.List;

public interface UserRepository {

    void create(User user);

    User findById(String id);

    List<User> findAll() throws FileNotFoundException;

    void update(User user);

    void deleteById(String id);

    void deleteAll();

}
