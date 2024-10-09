package attestation.attestation01.repository.impl;

import attestation.attestation01.exception.UserNotFoundException;
import attestation.attestation01.model.User;
import attestation.attestation01.repository.UserRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsersRepositoryFileImpl implements UserRepository {

    private static List<User> users = new ArrayList<>();

    private static final String PATH = "resources/users.txt";

    @Override
    public void create(User user) {
        try (FileWriter fileWriter = new FileWriter(PATH, true)) {
            fileWriter.write("\n");
            fileWriter.write(user.parseUserToString());
            users.add(user);
        } catch (IOException ioe) {
            throw new RuntimeException("Ошибка создания пользователя");
        }
        System.out.println("Пользователь создан");
    }

    @Override
    public User findById(String id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("Пользователь с id = " + id + " не найден."));
    }

    @Override
    public List<User> findAll() {
        try (FileReader fileReader = new FileReader(PATH)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            users = bufferedReader.lines()
                    .map(User::new)
                    .collect(Collectors.toList());
            return users;
        } catch (IOException ioe) {
            return new ArrayList<>();
        }
    }

    @Override
    public void update(User user) {
        User userToUpdate = users.stream()
                .filter(u -> u.getId().equals(user.getId()))
                .findFirst()
                .orElse(null);

        if (userToUpdate != null) {
            userToUpdate = user;
            try (FileWriter fileWriter = new FileWriter(PATH, false)) {
                for (User u : users) {
                    if (u.getId().equals(userToUpdate.getId())) {
                        u = userToUpdate;
                        fileWriter.write(u.parseUserToString());
                        fileWriter.write("\n");
                    } else {
                        fileWriter.write(u.parseUserToString());
                        fileWriter.write("\n");
                    }
                }
            } catch (IOException ioe) {
                throw new RuntimeException("Ошибка обновления пользователя");
            }

            System.out.println("Пользователь обновлён");
        }
    }

    @Override
    public void deleteById(String id) {
        if (users.stream().anyMatch(u -> u.getId().equals(id))) {
            try (FileWriter fileWriter = new FileWriter(PATH, false)) {
                users.removeIf(u -> u.getId().equals(id));
                for (User user : users) {
                    fileWriter.write(user.parseUserToString());
                    fileWriter.write("\n");
                }
            } catch (IOException ioe) {
                throw new RuntimeException("Ошибка удаления пользователя");
            }
            System.out.println("Пользователь удалён");
        } else {
            throw new UserNotFoundException("Пользователь с id = " + id + " не найден.");
        }

    }

    @Override
    public void deleteAll() {
        users.clear();

        try (FileWriter fileWriter = new FileWriter(PATH, false)) {
            fileWriter.write("");
        } catch (IOException ioe) {
            throw new RuntimeException("Ошибка удаления всех пользователей");
        }
        System.out.println("Пользователи удалены");
    }
}
