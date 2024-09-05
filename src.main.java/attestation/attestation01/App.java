package attestation.attestation01;

import attestation.attestation01.model.User;
import attestation.attestation01.repository.UserRepository;
import attestation.attestation01.repository.impl.UsersRepositoryFileImpl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

public class App {

    public static void main(String[] args) {
        try {
            UserRepository repository = new UsersRepositoryFileImpl();
            String id = UUID.randomUUID().toString();
            User userOne = new User(id, "login1", "password1", "password1", "Иванов", "Иван", "Иванович", 30, false);
            User userTwo = new User(UUID.randomUUID().toString(), "login2", "password2", "password2", "Андреев", "Андрей", "Андреевич", 35, true);

            repository.create(userOne);
            repository.create(userTwo);

            List<User> userList = repository.findAll();
            System.out.println(userList.toString());

            User findedUser = repository.findById(id);
            System.out.println(findedUser.toString());

            userOne.setAge(35);
            userOne.setWorker(true);

            repository.update(userOne);
            userList = repository.findAll();
            System.out.println(userList.toString());

            repository.deleteById(userTwo.getId());
            userList = repository.findAll();
            System.out.println(userList.toString());

            repository.deleteAll();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
