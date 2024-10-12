package ru.inno.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.inno.java.entity.Card;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findAllByUserId(Long userId);

    @Query("update Card c set c.deleted=true where c.id=?1")
    void softDelete(Long id);

}
