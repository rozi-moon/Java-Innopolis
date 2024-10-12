package ru.inno.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.inno.java.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.deleted = false")
    List<User> findAllActive();

    @Query("update User set deleted=true where id = ?1")
    void softDelete(Long id);

}
